package com.devskiller.tasks.blog.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Column(name = "author")
	private String author;
	@Column(name = "comment")
	private String comment;
	//private LocalDateTime creationDate;
	@Column(name = "comment_content")
    private String content;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	private Post post;

	public Post getPost() {
		return post;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

//	public LocalDateTime getCreationDate() {
//		return creationDate;
//	}
//
//	public void setCreationDate(LocalDateTime creationDate) {
//		this.creationDate = creationDate;
//	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Comment(String author, String comment, String content, Post post) {
		this.author = author;
		this.comment = comment;
		this.content = content;
		this.post = post;
	}

	public Long getId() {
		return id;
	}
}
