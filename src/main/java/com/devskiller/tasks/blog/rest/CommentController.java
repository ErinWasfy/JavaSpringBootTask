package com.devskiller.tasks.blog.rest;
import com.devskiller.tasks.blog.model.Account;
import com.devskiller.tasks.blog.model.Comment;
import com.devskiller.tasks.blog.model.dto.NewCommentDto;
import com.devskiller.tasks.blog.service.AccountService;
import com.devskiller.tasks.blog.service.CommentService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.Path;

@RestController
@RequestMapping("/api")
public class CommentController {
	private CommentService commentService;
	@Autowired
	public CommentController(CommentService comService)
	{
		this.commentService=comService;
	}
//	@PostMapping("/newcomment")
//	public ResponseEntity<Long> insertComment( @RequestBody Comment commentRequest)
//	{
//		Long commentId=commentService.addCommentToDB(1L,commentRequest);
//		return new ResponseEntity<Long>(commentId, HttpStatus.OK);
//	}
	@PostMapping("/{id}/newcommenttest")
	public ResponseEntity<Comment> insertCommenttest(@PathVariable("id") Long id, @RequestBody Comment comment)
	{
		Comment commentId=commentService.addCommentToDB(id,comment);
		//if(commentId!=null)
			return new ResponseEntity<Comment>(commentId, HttpStatus.CREATED);
	//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
//	@PostMapping("/createComment")
//	public Account createAccount(@RequestBody Account account,
//								 HttpServletResponse httpResponse,
//								 WebRequest request) {
//
//		Long accountId = accountService.createAccount(account);
//		account.setAccountId(accountId);
//
//		httpResponse.setStatus(HttpStatus.CREATED.value());
//		httpResponse.setHeader("Location", String.format("%s/api/account/%s",
//			request.getContextPath(), accountId));
//		return account;
//	}
}
