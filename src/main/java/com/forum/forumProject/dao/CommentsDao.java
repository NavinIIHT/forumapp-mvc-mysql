package com.forum.forumProject.dao;

import java.util.List;

import com.forum.forumProject.entity.Comments;

public interface CommentsDao 
{
	public Comments saveComment(Comments comments);
	
	public List<Comments> getAllComments(int postId);
}
