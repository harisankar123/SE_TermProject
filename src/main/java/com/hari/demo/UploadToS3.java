package com.hari.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service 
public class UploadToS3 {
	String fileURI;
	public String upload(String fileName, InputStream fs) {
		BasicAWSCredentials cred=new BasicAWSCredentials("AKIAIXAF6TBYBPQQYC6Q","QsBwvhdFNGJ0RiuuqgLB8ycfU1YdvQevWC9cBQey");
		AmazonS3 s3client= AmazonS3ClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(cred))
				.withRegion(Regions.US_EAST_2)
				.build(); 
		
			  //String myId =  (String)request.getSession().getAttribute("userId");
			
			 // System.out.println("name of the person is"+fileName);
			PutObjectRequest putrq= new PutObjectRequest("harisankar",fileName,fs,new ObjectMetadata())
					.withCannedAcl(CannedAccessControlList.PublicRead);
			s3client.putObject(putrq);
			 fileURI="http://"+"harisankar"+".s3.amazonaws.com/"+fileName;
			 return fileURI;
			 
		
	
	}
}
