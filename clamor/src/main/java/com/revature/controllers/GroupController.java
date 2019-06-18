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

import com.revature.models.Group;
import com.revature.models.GroupMessage;
import com.revature.models.Usergroup;
import com.revature.services.GroupMessageService;
import com.revature.services.GroupService;
import com.revature.services.UsergroupService;

@RestController
@RequestMapping("group")
public class GroupController {

	private GroupService groupService;
	private UsergroupService usergroupService;
	private GroupMessageService groupMessageService;

	@Autowired
	public GroupController(
			GroupService groupService, 
			UsergroupService usergroupService,
			GroupMessageService groupMessageService) {
		super();
		this.groupService = groupService;
		this.usergroupService = usergroupService;
		this.groupMessageService = groupMessageService;
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
		List<Group> canGroups = groupService.findByName(group.getName());

		if (canGroups.size() == 0) {
			return new Group(0, "", "", false);
		}
		
		return groupService.save(group);
	}
	
	// GET: All group messages from Group id {id}
	@GetMapping("/messages/{groupId}")
	public List<GroupMessage> getGroupMessages(int groupId) {
		return groupMessageService.findByGroupId(groupId);
	}
	
}
