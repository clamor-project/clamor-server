package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mute")
public class Mute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private UserGroup listener;
	
	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private UserGroup speaker;

	public Mute() {
		super();
	}

	public Mute(int id, UserGroup listener, UserGroup speaker) {
		super();
		this.id = id;
		this.listener = listener;
		this.speaker = speaker;
	}

	int getId() {
		return id;
	}

	void setId(int id) {
		this.id = id;
	}

	UserGroup getListener() {
		return listener;
	}

	void setListener(UserGroup listener) {
		this.listener = listener;
	}

	UserGroup getSpeaker() {
		return speaker;
	}

	void setSpeaker(UserGroup speaker) {
		this.speaker = speaker;
	}

	@Override
	public String toString() {
		return "Mute [id=" + id + ", listener=" + listener + ", speaker=" + speaker + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((listener == null) ? 0 : listener.hashCode());
		result = prime * result + ((speaker == null) ? 0 : speaker.hashCode());
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
		Mute other = (Mute) obj;
		if (id != other.id)
			return false;
		if (listener == null) {
			if (other.listener != null)
				return false;
		} else if (!listener.equals(other.listener))
			return false;
		if (speaker == null) {
			if (other.speaker != null)
				return false;
		} else if (!speaker.equals(other.speaker))
			return false;
		return true;
	}
}
