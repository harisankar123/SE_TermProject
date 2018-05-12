package com.hari.demo;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
public interface CommentRepository extends CrudRepository<Comment,Integer> {
	public List<Comment> findByPost(Post p);

}
