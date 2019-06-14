package com.revature.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "creator")
	private Usergroup creator;
	
	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JoinColumn(name = "group_id")
	private Group groupId;
	
	@NotNull
	private String description;

	@Column(name = "date_posted", columnDefinition="default now()")
	private Date datePosted;
	
	@Column(name = "date_of")
	@NotNull
	private Date dateOf;
	
	@Column(columnDefinition="default true")
	private boolean live;

	public Event() {
		super();
	}

	public Event(int id, Usergroup creator, Group groupId, @NotNull String description, Date datePosted,
			@NotNull Date dateOf, boolean live) {
		super();
		this.id = id;
		this.creator = creator;
		this.groupId = groupId;
		this.description = description;
		this.datePosted = datePosted;
		this.dateOf = dateOf;
		this.live = live;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usergroup getCreator() {
		return creator;
	}

	public void setCreator(Usergroup creator) {
		this.creator = creator;
	}

	public Group getGroupId() {
		return groupId;
	}

	public void setGroupId(Group groupId) {
		this.groupId = groupId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}

	public Date getDateOf() {
		return dateOf;
	}

	public void setDateOf(Date dateOf) {
		this.dateOf = dateOf;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", creator=" + creator + ", groupId=" + groupId + ", description=" + description
				+ ", datePosted=" + datePosted + ", dateOf=" + dateOf + ", live=" + live + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((dateOf == null) ? 0 : dateOf.hashCode());
		result = prime * result + ((datePosted == null) ? 0 : datePosted.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + id;
		result = prime * result + (live ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (dateOf == null) {
			if (other.dateOf != null)
				return false;
		} else if (!dateOf.equals(other.dateOf))
			return false;
		if (datePosted == null) {
			if (other.datePosted != null)
				return false;
		} else if (!datePosted.equals(other.datePosted))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (id != other.id)
			return false;
		if (live != other.live)
			return false;
		return true;
	}
}
