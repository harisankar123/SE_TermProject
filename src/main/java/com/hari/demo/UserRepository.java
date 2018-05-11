package com.hari.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
    public User findByUserId(String userId);
    public List<User> findAll();
    public boolean existsByUserId(String userId);
    public List<User> findByUserIdIn(ArrayList<String> al);
	
   
}