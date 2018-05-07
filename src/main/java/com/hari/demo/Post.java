package com.hari.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer postId;
	
	private String postPhoto;
	private String postAudio;
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
