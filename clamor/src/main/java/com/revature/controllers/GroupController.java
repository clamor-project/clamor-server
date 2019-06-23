package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Event;
import com.revature.models.Group;
import com.revature.models.GroupMessage;
import com.revature.models.User;
import com.revature.models.Usergroup;
import com.revature.services.EventService;
import com.revature.services.GroupMessageService;
import com.revature.services.GroupService;
import com.revature.services.UserService;
import com.revature.services.UsergroupService;

@RestController
@RequestMapping("group")
public class GroupController {

	private GroupService groupService;
	private UsergroupService usergroupService;
	private GroupMessageService groupMessageService;
	private EventService eventService;
	private UserService userService;

	@Autowired
	public GroupController(
			GroupService groupService, 
			UsergroupService usergroupService,
			GroupMessageService groupMessageService,
			EventService eventService,
			UserService userService) {
		super();
		this.groupService = groupService;
		this.usergroupService = usergroupService;
		this.groupMessageService = groupMessageService;
		this.eventService = eventService;
		this.userService = userService;
	}
	
	// GET: All Groups
	@GetMapping
	public List<Group> findAll() {
		return groupService.findAll();
	}
	
	// GET: Group by {id}
	@GetMapping("id/{id}")
	public Group findById(@PathVariable int id) {
		return groupService.findById(id);
	}
	
	// DELETE: Group by {id}
	@DeleteMapping("id/{id}")
	public boolean deleteById(@PathVariable int id) {
		try {
			groupService.deleteById(id);
		} catch(Exception e) {
			return false;
		}
		return true;
	}

	// GET: List of Usergroups by {id}
	@GetMapping("members/id/{id}")
	public List<Usergroup> findGroupMembers(@PathVariable int id) {
		return usergroupService.findByGroupId(id);
	}
	
	// GET: List of Groups where "name" is ILIKE {name}
	@GetMapping("search/name/{name}")
	public List<Group> searchName(@PathVariable String name) {
		return groupService.searchByName(name);
	}
	
	// GET: List of Groups where "description" is ILIKE {description}
	@GetMapping("search/description/{description}")
	public List<Group> searchDescription(@PathVariable String description) {
		return groupService.searchByDescription(description);
	}
	
	// GET: List of Groups where "name" OR "description" are ILIKE {query}
	@GetMapping("search/data/{query}")
	public List<Group> searchNameDescription(@PathVariable String query) {
		return groupService.searchByNameOrDescription(query);
	}
	
	// POST: New Group to database or return blank if problems
	@PostMapping(path="", consumes = "application/json", produces = "application/json")
	public Group createGroup(@RequestBody Usergroup usergroup) {
		List<Group> canGroups = groupService.findByName(usergroup.getGroup().getName());
		if (canGroups.size() >= 1) {
			return new Group(0, "", "", false);
		}
		
		Group ng = groupService.save(usergroup.getGroup());
		Usergroup nug = new Usergroup(0, usergroup.getUser(), ng, usergroup.getRole(), usergroup.getJoinedDate());
		usergroupService.save(nug);
		
		return ng;
	}

	// PATCH: Existing Group or return blank if problems
	@PatchMapping(path="", consumes = "application/json", produces="application/json")
	public Group updateGroup(@RequestBody Group group) {
		
		Group groupCheck = groupService.findById(group.getId());
		if (groupCheck != null) {
			return groupService.save(group);
		} else {
			return new Group(-1, "", "", false);
		}
	}
	
	// GET: All group messages from Group id {id}
	@GetMapping("/messages/{groupId}")
	public List<GroupMessage> getGroupMessages(@PathVariable int groupId) {
		return groupMessageService.findByGroupId(groupId);
	}
	
	// POST: New GroupMessage
	@PostMapping(path = "/messages", consumes = "application/json", produces="application/json")
	public GroupMessage postGroupMessage(@RequestBody GroupMessage groupMessage) {

		return groupMessageService.save(groupMessage);
	}
	
	// PATCH: Existing GroupMessage
	@PatchMapping(path = "/messages", consumes = "application/json", produces = "application/json")
	public GroupMessage patchGroupMessage(@RequestBody GroupMessage groupMessage) {

		GroupMessage groupMessageCheck = groupMessageService.findById(groupMessage.getId());
		if (groupMessageCheck != null) {
			return groupMessageService.save(groupMessage);
		} else {
			return new GroupMessage();
		}
	}
	
	// DELETE: Existing GroupMessage
	@DeleteMapping("/messages/{id}")
	public boolean deleteGroupMessage(@PathVariable int id) {
		
		try {
			groupMessageService.deleteById(id);
		} catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	// POST: New Usergroup
	@PostMapping("/join/{groupId}")
	public boolean joinGroup(@RequestBody User user, @PathVariable int groupId) {
		
		List<Usergroup> ugl = usergroupService.findByUserIdAndGroupId(user.getId(), groupId);
		if (ugl.size() == 0) {
			usergroupService.joinGroup(user.getId(), groupId, 2);
			return true;
		} else {
			Usergroup ug = ugl.get(0);
			if (ug.getRole().getId() != 3) {
				usergroupService.updateUsergroupRole(2, user.getId(), groupId);
				return true;
			}
		}
		return false;
	}
	
	// PATCH: Update usergroup set role to "4"
	// because nobody wanted them there anyway...
	@PatchMapping("/leave/{groupId}")
	public boolean leaveGroup(@RequestBody User user, @PathVariable int groupId) {
		
		Usergroup ug = (usergroupService.findByUserIdAndGroupId(user.getId(), groupId)).get(0);
		if (ug.getRole().getRoleName().equals("member")) {
			usergroupService.updateUsergroupRole(4, user.getId(), groupId);
			return true;
		}
		return false;
	}
	
	// GET: All events by Group ID
	@GetMapping("/event/{groupId}")
	public List<Event> findByGroupId(@PathVariable int groupId) {
		return eventService.findByGroupId(groupId);
	}
	
	// POST: New event
	@PostMapping("/event/{groupId}")
	public boolean createEvent(@RequestBody Event event, @PathVariable int groupId) {
		
		Usergroup ug = (usergroupService.findByUserIdAndGroupId(event.getCreator().getId(), groupId)).get(0);
		if (ug.getRole().getRoleName().contentEquals("member") || ug.getRole().getRoleName().equals("organizer")) {
			eventService.createEvent(event.getCreator().getId(), groupId, event.getTitle(), event.getDescription(), event.getDatePosted(), event.getDateOf(), event.isLive());
			return true;
		}
		
		return false;
	}
	
	// PATCH: event
	@PatchMapping("/event/{trustedId}")
	public Event updateEvent(@RequestBody Event event, @PathVariable int trustedId) {
		
		User user = userService.findById(trustedId);
		if (user.getId() != event.getCreator().getUser().getId()) {
			return null;
		}
		return eventService.save(event);
	}
	
	// DELETE: event
	@DeleteMapping("/event/{eventId}")
	public boolean deleteEvent(@RequestBody User user, @PathVariable int eventId) {
		
		Event event = eventService.findById(eventId);
		if (event.getCreator().getUser().getId() != user.getId()) {
			return false;
		}
		
		return eventService.deleteById(eventId);
	}
}
