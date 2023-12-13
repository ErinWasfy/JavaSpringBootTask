package com.devskiller.tasks.blog.rest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.devskiller.tasks.blog.model.Account;
import com.devskiller.tasks.blog.model.Comment;
import com.devskiller.tasks.blog.model.Post;
import com.devskiller.tasks.blog.model.dto.CommentDto;
import com.devskiller.tasks.blog.model.dto.NewCommentDto;
import com.devskiller.tasks.blog.model.dto.PostDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.hamcrest.core.AllOf;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@AutoConfigureMockMvc(addFilters = false)
public class CommentControllerTest extends AbstractControllerTest {


	@Test
	//@WithMockUser(roles = "ADMIN")
	public void shouldReturnFoundComments() throws Exception {

		// given
//		List<CommentDto> comments = new ArrayList<>();
//		LocalDateTime creationDate = LocalDateTime.of(2018, 5, 20, 20, 51, 16);
//		comments.add(new CommentDto(2L, "comment content", "John Smith"));
//
//		// when
//		when(commentService.getCommentsForPost(1L)).thenReturn(comments);
//
//		// then
//		mockMvc.perform(get("/posts/1/comments").with(csrf()).accept(APPLICATION_JSON))
//			.andExpect(status().isOk())
//			.andExpect(jsonPath("$", hasSize(1)))
//			.andExpect(jsonPath("$[0].id", is(2)))
//			.andExpect(jsonPath("$[0].comment", is("comment content")))
//			.andExpect(jsonPath("$[0].author", is("John Smith")))
//			.andExpect(jsonPath("$[0].creationDate", is(creationDate.toString())));

	}

	@Test
	//@WithMockUser(roles = "ADMIN")
	public void shouldAddComment() throws Exception {

		// given
		String commentBody = "{\"content\":\"Test content\", \"author\":\"John Doe\",\"Id\":\"2\"}";
		//NewCommentDto newComment = createComment("Test content", "John Doe");
		// when
		//when(commentService.addComment(any(), eq(newComment))).thenReturn(2L);
		Post post = new Post();
		post.setContent("Test");
		post.setTitle("testTitle");

		Comment newCommenttest=new Comment("John Doe","Test","Test content",post);
		// then
//		mockMvc.perform(post("/posts/1/comments")
//				.content(commentBody)
//				.contentType(APPLICATION_JSON)
//				.accept(APPLICATION_JSON))
//			.andExpect(status().isCreated());
		JSONObject json = new JSONObject();
		json.put("author", "John Doe");
		json.put("comment","Test");
		json.put("content","");
      NewCommentDto commentDto=new NewCommentDto("John Doe",newCommenttest.getContent());

		when(commentService.addCommentToDB(any(),any(Comment.class))).thenReturn(newCommenttest);
		mockMvc.perform(post("/api/1/newcommenttest").contentType(MediaType.APPLICATION_JSON).content(commentBody)//.with(csrf())
				.accept(MediaType.APPLICATION_JSON).contentType(APPLICATION_JSON))
			.andExpect(status().isCreated())
			.andExpect(content().contentType(APPLICATION_JSON))
			.andExpect(jsonPath("$.author").value("John Doe"));


	}

	private NewCommentDto createComment(String content, String author) {
		return new NewCommentDto(author, content);
	}
	@Test
	//@WithMockUser(roles = "ADMIN")
	public void should_CreateAccount_When_ValidRequest() throws Exception {

		when(accountService.createAccount(any(Account.class))).thenReturn(12345L);

		mockMvc.perform(post("/api/createComment")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{ \"accountType\": \"SAVINGS\", \"balance\": 5000.0 }")//.with(csrf())
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
			.andExpect(content().contentType(APPLICATION_JSON))
			.andExpect(header().string("Location", "/api/account/12345"))
			.andExpect(jsonPath("$.accountId").value("12345"))
			.andExpect(jsonPath("$.accountType").value("SAVINGS"))
			.andExpect(jsonPath("$.balance").value(5000));
	}
}
