package com.hari.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface FriendRepository extends CrudRepository<Friend,Integer> {

	public List<Friend> findByUser(User userobj);
	
}
