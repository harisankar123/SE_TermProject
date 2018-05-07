package com.hari.demo;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {

	
		@Id 
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String userId;
	private String name;
	private String profilephoto;
	private String description;
	
	
	
	/*public User(String userId, String name, String email, String profilephoto, String description,
			List<Friend> friendList) {
		super();
		this.userId = userId;
		this.name = name;
		
		this.profilephoto = profilephoto;
		this.description = description;
		this.friendList = friendList;
	}*/
	
	
	/*public User() {
		super();
		// TODO Auto-generated constructor stub
	}*/


	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String myId) {
		this.userId = myId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfilephoto() {
		return profilephoto;
	}
	public void setProfilephoto(String profilephoto) {
		this.profilephoto = profilephoto;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	/*public List<Post> getPostList() {
		return postList;
	}
	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}*/
	
	
	
}

	
