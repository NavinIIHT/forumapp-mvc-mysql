package com.forum.forumProject.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "comments")
public class Comments implements Serializable 
{
	private static final long serialVersionUID = -1826674065580787782L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "postid")
	private int postId;

	@Size(min = 1, max = 50)
	@Column(name = "author")
	private String author;
	
	@Size(min = 1, max = 50)
	@Column(name = "tags")
	private String tags;
	
	@Size(min = 1, max = 200)
	@Column(name = "visitorcomment")
	private String visitorComment;
	
	public Comments() {
		super();
	}
	
	public Comments(int id, String tags, String author,String visitorComment, int postId) {
		this.id = id;
		this.postId = postId;
		this.author = author;
		this.tags = tags;
		this.visitorComment = visitorComment;
	}

	
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getVisitorComment() {
		return visitorComment;
	}
	public void setVisitorComment(String visitorComment) {
		this.visitorComment = visitorComment;
	}
}