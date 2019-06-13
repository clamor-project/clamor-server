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
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private int attendee;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "event_id")
	private int eventId;

	public Rsvp() {
		super();
	}

	public Rsvp(int id, int attendee, int eventId) {
		super();
		this.id = id;
		this.attendee = attendee;
		this.eventId = eventId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAttendee() {
		return attendee;
	}

	public void setAttendee(int attendee) {
		this.attendee = attendee;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	@Override
	public String toString() {
		return "Rsvp [id=" + id + ", attendee=" + attendee + ", eventId=" + eventId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attendee;
		result = prime * result + eventId;
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
		if (attendee != other.attendee)
			return false;
		if (eventId != other.eventId)
			return false;
		if (id != other.id)
			return false;
		return true;
	}
}
