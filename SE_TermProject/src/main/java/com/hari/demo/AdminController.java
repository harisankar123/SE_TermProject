package com.hari.demo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class AdminController {
	@Autowired
	private AdminRepository aRepo;
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	UploadToS3 s3;
	
	@GetMapping("/adminProfile")
	public ModelAndView renderPage1(
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String userId= (String)req.getSession().getAttribute("userId");
		System.out.println(userId);
		List<User> user= aRepo.findAll();
		List<User> list=new ArrayList<User>();
	   user.forEach(u ->{
		  list.add(urepo.findByUserId(u.getUserId()));
	   });
		mv.addObject("user",list);
		 List<Post> post=aRepo.findByUserId(userId);
		 System.out.println(post);// @formatter:on
		mv.addObject("post", post);
	
		
		//mv.addObject("desc",user.getName());
		mv.setViewName("admin");	
		return mv;
	}
	
}
