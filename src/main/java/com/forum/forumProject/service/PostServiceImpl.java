package com.forum.forumProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forum.forumProject.dao.PostDao;
import com.forum.forumProject.entity.Posts;

@Service
@Transactional
public class PostServiceImpl implements PostService
{
	@Autowired
	private PostDao postDao;
	
	
	@Override
	public List<Posts> getAllPosts() {
		return null;
	}

	@Override
	public Posts savePost(Posts posts) {
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
