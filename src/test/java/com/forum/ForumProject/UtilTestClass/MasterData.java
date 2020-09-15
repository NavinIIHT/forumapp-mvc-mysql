package com.forum.ForumProject.UtilTestClass;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.forum.forumProject.entity.Comments;
import com.forum.forumProject.entity.Posts;

public class MasterData 
{
	public static Posts getPostDetails() 
	{
		Posts post = new Posts();
		
		//post.setId(1);
		post.setAuthor("First");
		post.setTitle("Spring Technology");
		post.setTags("Java");
		post.setPostDescription("Used in IT Sector");
		
		return post;
	}
	public static Comments getCommentDetails() 
	{
		Comments comments = new Comments();
		
		//comments.setPostId(1);
		//comments.setId(1);
		comments.setAuthor("Second");
		comments.setTags("I Like it");
		comments.setVisitorComment("Design Patterns are important in Java Technology");
		
		return comments;
	}
	
	public static List<Posts> getAllPosts(){
		List<Posts> posts = new ArrayList<Posts>();
		posts.add(new Posts(1, "Test1","First","#test1","Testing Post1"));
		posts.add(new Posts(2, "Test2","Second","#test2","Testing Post2"));
		posts.add(new Posts(3, "Test3","Third","#test3","Testing Post3"));
		posts.add(new Posts(4, "Test4","Fourth","#test4","Testing Post4"));
		posts.add(new Posts(5, "Test5","Fifth","#test5","Testing Post5"));
		return posts;
	}
	
	public static List<Posts> getAllPostsByAuthor(){
		List<Posts> posts = new ArrayList<Posts>();
		posts.add(new Posts(1, "Test1","First","#test1","Testing Post1"));
		posts.add(new Posts(2, "Test2","First","#test2","Testing Post2"));
		posts.add(new Posts(3, "Test3","First","#test3","Testing Post3"));
		posts.add(new Posts(4, "Test4","First","#test4","Testing Post4"));
		posts.add(new Posts(5, "Test5","First","#test5","Testing Post5"));
		return posts;
	}
	
	public static List<Comments> getCommentsOfId(){
		List<Comments> comments = new ArrayList<Comments>();
		comments.add(new Comments(1, "#test1", "First","Nice1",1));
		comments.add(new Comments(2, "#test2", "Second","Nice2",1));
		comments.add(new Comments(3, "#test3", "Third","Nice3",1));
		comments.add(new Comments(4, "#test4", "Fourth","Nice4",1));
		
		return comments;
	}
	
}






