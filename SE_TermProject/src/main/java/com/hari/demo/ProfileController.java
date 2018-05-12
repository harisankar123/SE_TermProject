package com.hari.demo;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

@Controller
public class ProfileController {
	
	@Autowired
	private UserRepository urepo;

	@Autowired
	private FriendRepository fRepo;
	
	@Autowired
	private PostRepository pRepo;
	
	@Autowired
	private CommentRepository cRepo;
	
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
			@RequestParam(name="myFriends") String myFriends,
			HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		
		request.getSession().setAttribute("userId",myId);
		request.getSession().setAttribute("myFriends",myFriends);
		
		System.out.println("session attrs :"+ myId);
//		String admin="1994771880778927";
		boolean bol = urepo.existsByUserId(myId);
//		if(myId==admin) {
//			mv.setViewName("/redirect/adminProfile");
//			retrun mv;
//		}
//		else{
		System.out.println("boolean b value "+bol);
		if(bol==true) {
			
			User user = urepo.findByUserId(myId);
			List<Friend> friend= fRepo.findByUser(user);
			List<User> list=new ArrayList<User>();
		   friend.forEach(f ->{
			  list.add(urepo.findByUserId(f.getFriendId()));
		   });
		     List<Post> posts= pRepo.findByUserId(user);
			System.out.println("Myfriends"+myFriends);
			mv.addObject("user",user);
			mv.addObject("friends",list);
			mv.addObject("post", posts);
			mv.setViewName("profile");
			return mv;
			
					}
		else {
			return new ModelAndView("createprofile");
			}
		}
	
//	@GetMapping("/facebookRedirect")
//	public ModelAndView renderProfilePage() {
//		ModelAndView mv = new ModelAndView();
//		
//		
//		mv.setViewName("profile");
//		return mv;
//	}
	
	
	@GetMapping("/createProfile")
	public ModelAndView renderPage() {
		ModelAndView mv = new ModelAndView();
		
		
		mv.setViewName("createprofile");
		return mv;
	}
	@GetMapping("/redirectProfile")
	public ModelAndView renderPage1(
			@RequestParam(name="userId") String userId) {
		ModelAndView mv = new ModelAndView();
		System.out.println(userId);
		User user= urepo.findByUserId(userId);
		List<Friend> friend= fRepo.findByUser(user);
		List<User> list=new ArrayList<User>();
	   friend.forEach(f ->{
		  list.add(urepo.findByUserId(f.getFriendId()));
	   });
		
		System.out.println(user);
		//mv.addObject("profile",user.getProfilephoto());
		mv.addObject("user",user);
		
		 List<Post> post=pRepo.findByUserId(user);
		 System.out.println(post);// @formatter:on
		mv.addObject("post", post);
		mv.addObject("friends",list);
		
		//mv.addObject("desc",user.getName());
		mv.setViewName("profile");	
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
			String myFriends=(String) request.getSession().getAttribute("myFriends");
			User user= new User();
			System.out.println("******"+name);
		 	System.out.println("session attrs in create profile:"+ name );
		 	List<Friend> list_friend = new ArrayList<Friend>();
		 	String[] friends=myFriends.split("/");
		 	user.setUserId(myId);
		 	user.setName(name);
		 	user.setDescription(desc);
		 	user.setProfilephoto(addr);
		 	
		 	for(int i=0; i<friends.length;i+=2) {
		 		Friend f = new Friend();
		 		f.setFriendId(friends[i]);
		 		f.setUser(user);
		 		list_friend.add(f);
		 	}
		 	user.setFriendList(list_friend);
			urepo.save(user);
			profilepage.addObject("user",user);
			profilepage.setViewName("profile");
			return profilepage;
	}
	@GetMapping("/back2home")
	public ModelAndView renderPage1() {
		ModelAndView mv = new ModelAndView();
		
		
		mv.setViewName("profile");
		return mv;
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