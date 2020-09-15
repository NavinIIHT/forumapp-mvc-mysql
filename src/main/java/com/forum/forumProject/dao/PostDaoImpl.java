package com.forum.forumProject.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.forum.forumProject.entity.Posts;
 
@Repository
@Transactional
public class PostDaoImpl implements PostDao 
{
    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public Posts savePost(Posts posts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Posts> getAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Posts> getAllPostsByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Posts getPost(int postId) {
		// TODO Auto-generated method stub
		return null;
	}
 
	
}