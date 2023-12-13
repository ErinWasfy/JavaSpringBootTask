package com.devskiller.tasks.blog.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.devskiller.tasks.blog.model.Comment;
import com.devskiller.tasks.blog.model.Post;
import com.devskiller.tasks.blog.repository.PostCommentRepository;
import com.devskiller.tasks.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devskiller.tasks.blog.model.dto.CommentDto;
import com.devskiller.tasks.blog.model.dto.NewCommentDto;

@Service
public class CommentService {

   private final PostRepository postRepository;
   private final PostCommentRepository postCommentRepository;

   @Autowired
   public CommentService(PostRepository postRepository,PostCommentRepository postComRep)
   {
	   this.postRepository=postRepository;
	   this.postCommentRepository=postComRep;
   }
	/**
	 * Returns a list of all comments for a blog post with passed id.
	 *
	 * @param postId id of the post
	 * @return list of comments sorted by creation date descending - most recent first
	 */

	public List<CommentDto> getCommentsForPost(Long postId) {

    return postCommentRepository.findById(postId).map(mp->new CommentDto(mp.getId(),mp.getContent(),mp.getAuthor())).stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

		 //.map(mp->new CommentDto(mp.getId(),mp.,mp.getAuthor(),mp.getCreationDate())).collect(Collectors.toList());
	}

	/**
	 * Creates a new comment
	 *
	 * @param postId id of the post
	 * @param newCommentDto data of new comment
	 * @return id of the created comment
	 *
	 * @throws IllegalArgumentException if postId is null or there is no blog post for passed postId
	 */
	public Long addComment(Long postId, NewCommentDto newCommentDto) {
       Post post=postRepository.findById(postId).get();
		Comment comment=new Comment("","","",null);
		comment.setPost(post);
		comment.setAuthor(newCommentDto.author());
		comment.setContent(newCommentDto.content());
  	return postCommentRepository.save(comment).getId();
	}
	public Comment addCommentToDB(Long postId,Comment comment)
	{
		return new Comment("John Doe","","",null);
//		return postRepository.findById(postId).map(post -> {
//			comment.setPost(post);
//			return postCommentRepository.save(comment);
//		}).map(res->new Comment(comment.getAuthor(),"",comment.getContent(),postRepository.findById(postId).get())).get();
	}
}
