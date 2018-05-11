package com.hari.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AdminRepository extends CrudRepository<User,Integer> {

	public List<User> findAll();
	public List<Post> findByUserId(String userId);

}