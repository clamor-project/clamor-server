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
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private int listener;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private int speaker;

	public Mute() {
		super();
	}

	public Mute(int id, int listener, int speaker) {
		super();
		this.id = id;
		this.listener = listener;
		this.speaker = speaker;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getListener() {
		return listener;
	}

	public void setListener(int listener) {
		this.listener = listener;
	}

	public int getSpeaker() {
		return speaker;
	}

	public void setSpeaker(int speaker) {
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
		result = prime * result + listener;
		result = prime * result + speaker;
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
		if (listener != other.listener)
			return false;
		if (speaker != other.speaker)
			return false;
		return true;
	}
}
