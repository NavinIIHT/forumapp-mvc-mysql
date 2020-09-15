package com.forum.forumProject.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "postData")
public class Posts implements Serializable 
{
	private static final long serialVersionUID = -1826674065580787782L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Size(min = 1, max = 50)
	@Column(name = "author")
	@NotBlank(message = "Author name empty!")
	private String author;
	
	
	@Size(min = 1, max = 50)
	@Column(name = "title")
	private String title;
	
	@Size(min = 1, max = 50)
	@Column(name = "tags")
	private String tags;
	
	@Size(min = 1, max = 200)
	@Column(name = "postDescription")
	private String postDescription;
	
   
 
	public Posts() {
		super();
	}
	
	public Posts(int id, String title, String author, String tags, String postDescription) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.tags = tags;
		this.postDescription = postDescription;
		
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getPostDescription() {
		return postDescription;
	}
	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}

	@Override
	public String toString() {
		return "Posts [id=" + id + ", author=" + author + ", title=" + title + ", tags=" + tags + ", postDescription="
				+ postDescription + "]";
	}	
	
	
}