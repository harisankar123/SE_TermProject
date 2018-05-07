package com.hari.demo;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PostRepository extends CrudRepository<Post, Integer>{
		public Post findByUserId(String id);
	    public List<Post> findAll();
	    //public boolean existsByUserId(String id);
	    //public List<User> findByUserIdIn(ArrayList<String> al);

}
