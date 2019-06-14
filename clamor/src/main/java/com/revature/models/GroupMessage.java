package com.revature.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "group_message")
public class GroupMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private UserGroup author;
	
	@Column(name = "date_created", columnDefinition = "default now()")
	private Date dateCreated;
	
	@NotNull
	private String content;

	public GroupMessage() {
		super();
	}

	public GroupMessage(int id, UserGroup author, Date dateCreated, @NotNull String content) {
		super();
		this.id = id;
		this.author = author;
		this.dateCreated = dateCreated;
		this.content = content;
	}

	int getId() {
		return id;
	}

	void setId(int id) {
		this.id = id;
	}

	UserGroup getAuthor() {
		return author;
	}

	void setAuthor(UserGroup author) {
		this.author = author;
	}

	Date getDateCreated() {
		return dateCreated;
	}

	void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	String getContent() {
		return content;
	}

	void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "GroupMessage [id=" + id + ", author=" + author + ", dateCreated=" + dateCreated + ", content=" + content
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
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
		GroupMessage other = (GroupMessage) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
}
