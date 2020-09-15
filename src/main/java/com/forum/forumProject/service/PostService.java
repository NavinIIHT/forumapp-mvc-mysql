package com.forum.forumProject.service;

import java.util.List;

import com.forum.forumProject.entity.Posts;

public interface PostService 
{
	public Posts savePost(Posts posts);
	
	public List<Posts> getAllPosts();
	
	public List<Posts> getAllPostsByAuthor(String author);
	
	public Posts getPost(int postId);
}
