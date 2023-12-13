package com.devskiller.tasks.blog.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Long id;
    @Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;
    @Column(name = "creation_date")
	private LocalDateTime creationDate;
 @OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "comment")
   private List<Comment> comments;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}
   public void addComment(Comment comment)
   {
	   if(comments==null)
		   comments=new ArrayList<>();
	   comments.add(comment);
	   comment.setPost(this);
   }
	public List<Comment> getComments() {
		return comments;
	}


}
