package com.forum.ForumProject.EntityValidationTest;

import static com.forum.ForumProject.UtilTestClass.TestUtils.boundaryTestFile;
import static com.forum.ForumProject.UtilTestClass.TestUtils.currentTest;
import static com.forum.ForumProject.UtilTestClass.TestUtils.yakshaAssert;

//import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

//import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import com.forum.ForumProject.UtilTestClass.MasterData;
import com.forum.forumProject.entity.Comments;
import com.forum.forumProject.entity.Posts;

public class TestEntityValidation {

    private Validator validator;

  
    //----------------------------------------------------------------------------------------------
    @Before
    public void setUp() throws IOException
    {
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //----------------------------------------------------------------------------------------------
    @Test
    public void testPostSuccess() throws IOException
    {
    	Posts posts = MasterData.getPostDetails();
        Set<ConstraintViolation<Posts>> violations = validator.validate(posts);
        
	    yakshaAssert(currentTest(), violations.isEmpty() ? true : false, boundaryTestFile);

        
    }
    
    @Test
    public void testPostFailed() throws IOException
    {
    	Posts posts = MasterData.getPostDetails();
    	posts.setAuthor(null);
        Set<ConstraintViolation<Posts>> violations = validator.validate(posts);
        System.out.println(violations.isEmpty());
	    yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);

	    //File file = new File("entity_output_revised.txt");
	    //FileUtils.write(file, "\ntestPostFailed="+(violations.isEmpty() ? false : true), true);
    }

    //----------------------------------------------------------------------------------------------
    @Test
    public void testCommentSuccess() throws IOException
    {
    	Comments comments = MasterData.getCommentDetails();
        Set<ConstraintViolation<Comments>> violations = validator.validate(comments);

	    yakshaAssert(currentTest(), violations.isEmpty() ? true : false, boundaryTestFile);

	    //File file = new File("entity_output_revised.txt");
	    //FileUtils.write(file, "\ntestCommentSuccess="+(violations.isEmpty() ? true : false), true);
    }
    
    @Test
    public void testCommentFailed() throws IOException
    {
    	Comments comments = MasterData.getCommentDetails();
    	comments.setVisitorComment(null);
        Set<ConstraintViolation<Comments>> violations = validator.validate(comments);

	    yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);

	    //File file = new File("entity_output_revised.txt");
	    //FileUtils.write(file, "\ntestCommentFailed="+(violations.isEmpty() ? false : true), true);
    }
}