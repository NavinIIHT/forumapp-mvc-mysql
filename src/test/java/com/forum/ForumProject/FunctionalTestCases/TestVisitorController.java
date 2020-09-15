package com.forum.ForumProject.FunctionalTestCases;

import static com.forum.ForumProject.UtilTestClass.TestUtils.businessTestFile;
import static com.forum.ForumProject.UtilTestClass.TestUtils.currentTest;
import static com.forum.ForumProject.UtilTestClass.TestUtils.yakshaAssert;
import static com.forum.ForumProject.UtilTestClass.TestUtils.asJsonString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

//import java.io.File;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.forum.ForumProject.UtilTestClass.MasterData;

import com.forum.forumProject.config.WebMvcConfig;
import com.forum.forumProject.controller.VisitorController;
import com.forum.forumProject.entity.Comments;
import com.forum.forumProject.entity.Posts;
import com.forum.forumProject.service.CommentService;
import com.forum.forumProject.service.PostService;


public class TestVisitorController 
{
	@Mock
	private PostService postService;

	@Mock
	private CommentService commentService;

	@InjectMocks
	private VisitorController visitorController;

	
	//@Autowired
    //private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;

	
	@Before
	public void setup() throws Exception 
	{
		//Mockito.reset(this.postService);
		//Mockito.reset(this.commentService);
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(visitorController).build();
		// mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	// -------------------------------------------------------------------------------------------------------------------
	/*
	 * Description	: This test is to perform Loading the landing page URL
	 */
	@Test
	public void testLoadingPageUrl() throws Exception 
	{
		MvcResult result = this.mockMvc.perform(get("/")).andReturn();
		System.out.println(result.getResponse().getForwardedUrl());
	    yakshaAssert(currentTest(), 
	    		result.getResponse().getForwardedUrl()!=null && result.getResponse().getForwardedUrl().contentEquals("index") ? true : false, 
	    			businessTestFile);
	}
	
	@Test
	public void testAddNewPostUrl() throws Exception 
	{
		MvcResult result = this.mockMvc.perform(get("/addNewPost")).andReturn();
		System.out.println(result.getResponse().getForwardedUrl());
	    yakshaAssert(currentTest(), 
	    		result.getResponse().getForwardedUrl()!=null && result.getResponse().getForwardedUrl().contentEquals("add-post") ? true : false, 
	    			businessTestFile);
	}
	
	

	@Test
	public void testSaveNewPost() throws Exception 
	{
		Posts post = MasterData.getPostDetails();
		Posts addedPost = MasterData.getPostDetails();
		addedPost.setId(1);
		Mockito.when(this.postService.savePost(post)).thenReturn(addedPost);
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/savePost")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("author",post.getAuthor())
				.param("title", post.getTitle())
				.param("tags", post.getTags())
				.param("postDescription", post.getPostDescription());
				
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getRedirectedUrl());
		// result.getResponse().get
		System.out.println(result.getResponse().getForwardedUrl());
		yakshaAssert(currentTest(), 
				result.getResponse().getRedirectedUrl()!=null && result.getResponse().getRedirectedUrl().contentEquals("post-list") ? true : false, 
    			businessTestFile);
		
		
	}
	
	@Test
	public void testViewAllPosts() throws Exception 
	{
		List<Posts> posts = MasterData.getAllPosts();
		Mockito.when(this.postService.getAllPosts()).thenReturn(posts);
		MvcResult result = this.mockMvc.perform(get("/viewAllPosts")).andReturn();
		
		yakshaAssert(currentTest(), 
				result.getResponse().getForwardedUrl()!=null && result.getResponse().getForwardedUrl().contentEquals("post-list") ? true : false, 
    			businessTestFile);
		
		
	}
	
	
	
	@Test
	public void testViewPostById() throws Exception 
	{
		Posts post = MasterData.getPostDetails();
		post.setId(1);
		Mockito.when(this.postService.getPost(1)).thenReturn(post);
		Mockito.when(this.commentService.getAllComments(1)).thenReturn(MasterData.getCommentsOfId());
		MvcResult result = this.mockMvc.perform(get("/viewPostById/" + 1)).andReturn();
		yakshaAssert(currentTest(), 
				result.getResponse().getForwardedUrl()!=null && result.getResponse().getForwardedUrl().contentEquals("post-details") ? true : false, 
    			businessTestFile);
		
		
	}
	
	@Test
	public void testSaveNewComment() throws Exception 
	{
		Comments comment = MasterData.getCommentDetails();
		Comments addedComment = MasterData.getCommentDetails();
		addedComment.setId(1);
		Mockito.when(this.commentService.saveComment(comment,1)).thenReturn(addedComment);
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveComment/1")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("author",comment.getAuthor())
				.param("tags", comment.getTags())
				.param("visitorComment", comment.getVisitorComment());
				
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getRedirectedUrl());
		// result.getResponse().get
		System.out.println(result.getResponse().getForwardedUrl());
		yakshaAssert(currentTest(), 
				result.getResponse().getRedirectedUrl()!=null && result.getResponse().getRedirectedUrl().contentEquals("post-list") ? true : false, 
    			businessTestFile);
		
		
	}

	@Test
	public void testViewAllPostsByAuthor() throws Exception 
	{
		List<Posts> posts = MasterData.getAllPostsByAuthor();
		Mockito.when(this.postService.getAllPostsByAuthor("First")).thenReturn(posts);
		MvcResult result = this.mockMvc.perform(get("/viewPostByAuthor/First")).andReturn();
		
		yakshaAssert(currentTest(), 
    			result.getResponse().getForwardedUrl()!=null && result.getResponse().getForwardedUrl().contentEquals("post-list") ? true : false, 
    			businessTestFile);
		
		
	}
	
	
	@Test
	public void testAddNewPostValidation() throws Exception 
	{
		Posts post = MasterData.getPostDetails();
		post.setAuthor("");
		Posts addedPost = MasterData.getPostDetails();
		addedPost.setId(1);
		Mockito.when(this.postService.savePost(post)).thenReturn(addedPost);
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/savePost")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("author",post.getAuthor())
				.param("title", post.getTitle())
				.param("tags", post.getTags())
				.param("postDescription", post.getPostDescription());
				
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getForwardedUrl());
		// result.getResponse().get
		
		yakshaAssert(currentTest(),
				result.getResponse().getForwardedUrl()!=null && result.getResponse().getForwardedUrl().contentEquals("add-post") ? true : false,
				businessTestFile);
		
		
	}
	
	@Test
	public void testSaveNewCommentValidation() throws Exception 
	{
		Comments comment = MasterData.getCommentDetails();
		comment.setAuthor("");
		Comments addedComment = MasterData.getCommentDetails();
		addedComment.setId(1);
		Mockito.when(this.commentService.saveComment(comment,1)).thenReturn(addedComment);
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveComment/1")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("author",comment.getAuthor())
				.param("tags", comment.getTags())
				.param("visitorComment", comment.getVisitorComment());
				
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getRedirectedUrl());
		// result.getResponse().get
		System.out.println(result.getResponse().getForwardedUrl());
		yakshaAssert(currentTest(), 
				result.getResponse().getRedirectedUrl()!=null && result.getResponse().getRedirectedUrl().contentEquals("post-details") ? true : false, 
    			businessTestFile);
		
		
	}
	
	
}