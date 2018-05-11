package com.hari.demo;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface PostRepository extends CrudRepository<Post, Integer>{
	    public List<Post> findAll();
		public List<Post> findByUserId(String userId);
		
}