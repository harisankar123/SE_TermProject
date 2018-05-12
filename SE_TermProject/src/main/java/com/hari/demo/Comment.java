package com.hari.demo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="comment")
public class Comment {
	@Id
	private Integer commentId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="postId")
	private Post post;
	private String commentText;
	private Date timestamp;
	
	public Post getPostId() {
		return post;
	}
	public void setPostId(Post postId) {
		this.post = postId;
	}
	
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
