package com.hari.demo;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PostRepository extends CrudRepository<Post, Integer>{
	    public List<Post> findAll();
		public List<Post> findByUserId(User user);
		public Post findByPostId(Integer id);
		
}