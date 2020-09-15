package com.forum.ForumProject.ExceptionTestCases;

import static com.forum.ForumProject.UtilTestClass.TestUtils.exceptionTestFile;
import static com.forum.ForumProject.UtilTestClass.TestUtils.businessTestFile;
import static com.forum.ForumProject.UtilTestClass.TestUtils.currentTest;
import static com.forum.ForumProject.UtilTestClass.TestUtils.yakshaAssert;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.forum.ForumProject.UtilTestClass.MasterData;
import com.forum.forumProject.controller.VisitorController;
import com.forum.forumProject.entity.Posts;
import com.forum.forumProject.service.CommentService;
import com.forum.forumProject.service.PostService;

public class ExceptionTest {
	@Mock
	private PostService postService;

	@Mock
	private CommentService commentService;

	@InjectMocks
	private VisitorController visitorController;

	
	private MockMvc mockMvc;

	
	@Before
	public void setup() throws Exception 
	{
		
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(visitorController).build();
		
	}
	@Test
	public void testViewPostByIdException() throws Exception 
	{
		
		Mockito.when(this.postService.getPost(2)).thenReturn(null);
		Mockito.when(this.commentService.getAllComments(2)).thenReturn(null);
		MvcResult result = this.mockMvc.perform(get("/viewPostById/" + 2)).andReturn();
		yakshaAssert(currentTest(), 
				result.getResponse().getForwardedUrl()!=null && result.getResponse().getForwardedUrl().contentEquals("error") ? true : false, 
    			exceptionTestFile);
		
		
	}
	
}
