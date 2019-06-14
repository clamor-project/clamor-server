package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rsvp")
public class Rsvp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private UserGroup attendee;
	
	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JoinColumn(name = "event_id")
	private Event event;

	public Rsvp() {
		super();
	}

	public Rsvp(int id, UserGroup attendee, Event event) {
		super();
		this.id = id;
		this.attendee = attendee;
		this.event = event;
	}

	int getId() {
		return id;
	}

	void setId(int id) {
		this.id = id;
	}

	UserGroup getAttendee() {
		return attendee;
	}

	void setAttendee(UserGroup attendee) {
		this.attendee = attendee;
	}

	Event getEvent() {
		return event;
	}

	void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Rsvp [id=" + id + ", attendee=" + attendee + ", event=" + event + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attendee == null) ? 0 : attendee.hashCode());
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + id;
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
		Rsvp other = (Rsvp) obj;
		if (attendee == null) {
			if (other.attendee != null)
				return false;
		} else if (!attendee.equals(other.attendee))
			return false;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
}
