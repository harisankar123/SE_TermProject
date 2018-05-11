package com.hari.demo;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User {

	
	@Id 
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String userId;
	private String name;
	private String email;
	private String profilephoto;
	private String description;
	@OneToMany(
	        mappedBy = "user", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	    )	
	private List<Friend> friendList;
	public List<Friend> getFriendList() {
		return friendList;
	}
	
	public void setFriendList(List<Friend> friendList) {
		this.friendList = friendList;	
		}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	/*public List<Post> getPostList() {
		return postList;
	}
	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}*/
	
	
	
}

	
