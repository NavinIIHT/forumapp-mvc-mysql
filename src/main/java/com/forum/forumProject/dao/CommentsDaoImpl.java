package com.forum.forumProject.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.forum.forumProject.entity.Comments;

@Repository@Transactional
public class CommentsDaoImpl implements CommentsDao
{
    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public Comments saveComment(Comments comments) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comments> getAllComments(int postId) {
		// TODO Auto-generated method stub
		return null;
	}
 
	
}
