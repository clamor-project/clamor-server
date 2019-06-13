package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "invitation")
public class Invitation {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private int host;
	
	@ManyToOne
	private int subject;

	public Invitation() {
		super();
	}

	public Invitation(int id, int host, int subject) {
		super();
		this.id = id;
		this.host = host;
		this.subject = subject;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHost() {
		return host;
	}

	public void setHost(int host) {
		this.host = host;
	}

	public int getSubject() {
		return subject;
	}

	public void setSubject(int subject) {
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
		result = prime * result + host;
		result = prime * result + id;
		result = prime * result + subject;
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
		if (host != other.host)
			return false;
		if (id != other.id)
			return false;
		if (subject != other.subject)
			return false;
		return true;
	}
}
