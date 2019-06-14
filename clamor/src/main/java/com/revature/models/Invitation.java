package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "invitation")
public class Invitation {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JoinColumn(name = "host")
	private Usergroup host;
	
	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JoinColumn(name = "subject")
	private User subject;

	public Invitation() {
		super();
	}

	public Invitation(int id, Usergroup host, User subject) {
		super();
		this.id = id;
		this.host = host;
		this.subject = subject;
	}

	int getId() {
		return id;
	}

	void setId(int id) {
		this.id = id;
	}

	Usergroup getHost() {
		return host;
	}

	void setHost(Usergroup host) {
		this.host = host;
	}

	User getSubject() {
		return subject;
	}

	void setSubject(User subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Invitation [id=" + id + ", host=" + host + ", subject=" + subject + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + id;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		Invitation other = (Invitation) obj;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (id != other.id)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}
}
