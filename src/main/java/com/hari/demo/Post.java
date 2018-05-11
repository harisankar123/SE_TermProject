package com.hari.demo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private Integer postId;
	
	private String postPhoto;
	private String postAudio;
//	@OneToMany(
//	        mappedBy = "post", 
//	        cascade = CascadeType.ALL, 
//	        orphanRemoval = true
//	    )	
//	private List<Comment> commentList;
	
//	public List<Comment> getCommentList() {
//		return commentList;
//	}
//	public void setCommentList(List<Comment> commentList) {
//		this.commentList = commentList;
//	}
	private String userId;
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getPostPhoto() {
		return postPhoto;
	}
	public void setPostPhoto(String postPhoto) {
		this.postPhoto = postPhoto;
	}
	public String getPostAudio() {
		return postAudio;
	}
	public void setPostAudio(String postAudio) {
		this.postAudio = postAudio;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
