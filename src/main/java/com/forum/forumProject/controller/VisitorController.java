package com.forum.forumProject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.forum.forumProject.entity.Comments;
import com.forum.forumProject.entity.Posts;
import com.forum.forumProject.exception.ForumException;
import com.forum.forumProject.service.CommentService;
import com.forum.forumProject.service.PostService;

@Controller
public class VisitorController 
{
	@Autowired
	private PostService postService;

	@Autowired
	private CommentService commentService;

	// --------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView visitorPage() throws IOException {
		return null;
	}

	// --------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/addNewPost", method = RequestMethod.GET)
	public ModelAndView addPost() {
		return null;
	}

	// --------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/savePost", method = RequestMethod.POST)
	public ModelAndView savePost(@Valid @ModelAttribute("post") Posts post, BindingResult result) {
		return null;
	}

	// --------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/viewAllPosts", method = RequestMethod.GET)
	public ModelAndView getAllPosts() {
		ModelAndView mv = new ModelAndView("all-posts");
		
		return mv;
	}

	
	@RequestMapping(value = "/viewPostById/{postId}", method = RequestMethod.GET)
	public ModelAndView getPostById(@PathVariable("postId") int postId) {
		return null;
	}
	
	 
	// --------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/saveComment/{postId}", method = RequestMethod.POST)
	public ModelAndView saveComments(@PathVariable("postId") int postId, @Valid @ModelAttribute Comments comment, BindingResult result ) 
	{
		return null;
	}

	// --------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/viewPostByAuthor/{author}", method = RequestMethod.GET)
	public ModelAndView viewAllDiscussionTitles(@PathVariable("author") String author) {
		return null;
	}
	
	@ExceptionHandler(ForumException.class)
	public ModelAndView handleException(ForumException ex) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception", ex);
		return mv;
	}
	
}