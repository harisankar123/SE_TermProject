package com.hari.demo;



import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.hari.demo.User;
import com.hari.demo.Post;
@Controller
public class ProfileController {
	
	@Autowired
	private UserRepository urepo;
	@Autowired
	UploadToS3 s3;
	
	@GetMapping(value="/")
	public ModelAndView renderIndex() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("facebookindex");
		return mv;
	}
	@PostMapping(value="/facebookRedirect")
	public ModelAndView handleRedirect(
			@RequestParam(name="myId") String myId,
			HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		
		request.getSession().setAttribute("userId",myId);
		
		
		System.out.println("session attrs :"+ myId);
		
		boolean bol = urepo.existsByUserId(myId);
		System.out.println("boolean b value "+bol);
		if(bol==true) {
			
			User user = urepo.findByUserId(myId);
			mv.addObject(user);
			//System.out.println(user);
		
			  			
			mv.setViewName("profile");
			return mv;
			
					}
		else {
			return new ModelAndView("createprofile");
			}
	}
	@GetMapping("/createProfile")
	public ModelAndView renderPage() {
		ModelAndView mv = new ModelAndView();
		
		
		mv.setViewName("createprofile");
		return mv;
	}
	@PostMapping(value="/upload")
	public ModelAndView uploadToS3( @RequestParam("file") MultipartFile image,
			@RequestParam(name="desc") String desc,
			@RequestParam(name="name") String name,
						
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
			ModelAndView profilepage = new ModelAndView();
			String addr = s3.upload(image.getOriginalFilename(),image.getInputStream());
			System.out.println(addr); 
			String myId = (String)request.getSession().getAttribute("userId");
			System.out.println(myId); 
			User user= new User();
			System.out.println("******"+name);
		 	System.out.println("session attrs in create profile:"+ name );
		 	user.setUserId(myId);
		 	user.setName(name);
		 	user.setDescription(desc);
		 	user.setProfilephoto(addr);
			urepo.save(user);
			profilepage.addObject("user",user);
			profilepage.setViewName("profile");
			return profilepage;
	}
	
	@PostMapping(value="/logout")
	public ModelAndView logout(HttpServletRequest req)
	{
		ModelAndView view =new ModelAndView();
		req.getSession().invalidate();
		view.setViewName("FacebookLogin");
		
		return view;
		}
	
}