package com.devskiller.tasks.blog.rest;

import com.devskiller.tasks.blog.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.devskiller.tasks.blog.model.dto.PostDto;
import com.devskiller.tasks.blog.service.PostService;

import java.util.List;

@Controller
@RestController
@RequestMapping("/posts")
public class PostController {

	private final PostService postService;

@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PostDto getPost(@PathVariable Long id) {
		return postService.getPost(id);
	}
	@PostMapping("/{id}/comments")
	public ResponseEntity<List<Comment>> allcomments(@PathVariable("id") Long id)
	{
		return new ResponseEntity<List<Comment>>(postService.getCommentsByPostId(id),HttpStatus.OK);
	}


}
