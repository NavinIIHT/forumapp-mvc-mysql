package com.forum.forumProject.service;

import java.util.List;

import com.forum.forumProject.entity.Comments;

public interface CommentService 
{
	public Comments saveComment(Comments comments, int postId);
	
	public List<Comments> getAllComments(int postId);
}
