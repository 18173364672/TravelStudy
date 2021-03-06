package com.accp.hx.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.Dynamicpicture;

import com.accp.domain.Post;
import com.accp.domain.Project;
import com.accp.domain.ProjectExample;
import com.accp.hx.service.DynamicpictureService;
import com.accp.hx.service.PostService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



@Controller
@RestController
@RequestMapping("/postcontroller") 
public class PostController {

	@Autowired
	PostService PostService;
	
	@Autowired
	DynamicpictureService DynamicpictureService;
	
	@RequestMapping("/postxxselect")
	public Post postxxselect(Integer id) {
		Post list=PostService.postxxselect(id);
		String o=JSON.toJSONString(list);
		System.out.println(o);
		return list;
	}

	
	@RequestMapping("/postselect")
	public PageInfo<Post> postselect(Integer cuur,Integer tid) {
		Integer cur=1;
		if(cuur!=null) {
			cur=cuur;
		}
		PageHelper.startPage(cur,2);
	PageInfo<Post> page=new PageInfo<Post>(PostService.postselect(tid));
	System.out.println(JSON.toJSON(page));
	return page;
	}
	
	
	@RequestMapping("/fileUpload")
	public String fileUpload(MultipartFile file1 , MultipartFile file2 , MultipartFile file3,String userid, String title, Date dytime, String dycontent, Integer pointsum, Integer tid) {
		System.out.println("4");
		String url = "d:/fileupload/";
		File filePath = new File(url);
		if(!filePath.exists()) {
			filePath.mkdirs();
		}
		String url1 = "http://192.168.43.159:8080/TravelStudy/fileupload/";
		try {
			Post i = new Post(Integer.parseInt(userid),title,new Date(),dycontent,0,tid);
			PostService.insert(i);
			if(file1 != null) {
				System.out.println("s");
				String uuid = UUID.randomUUID().toString();
				String name = file1.getOriginalFilename();
				String suffix = name.substring(name.lastIndexOf("."), name.length());
				File fileImg = new File(url+uuid+suffix);
				file1.transferTo(fileImg);
				Dynamicpicture ii = new Dynamicpicture();
				ii.setDyid(i.getId());
				ii.setUrl(url1+uuid+suffix);
				System.out.println(i.getId());
				System.out.println(url1+uuid+suffix);
				DynamicpictureService.insert(ii);
			}
			if(file2 != null) {
				System.out.println("s");
				String uuid = UUID.randomUUID().toString();
				String name = file1.getOriginalFilename();
				String suffix = name.substring(name.lastIndexOf("."), name.length());
				File fileImg = new File(url+uuid+suffix);
				file1.transferTo(fileImg);
				Dynamicpicture ii = new Dynamicpicture();
				ii.setDyid(i.getId());
				ii.setUrl(url1+uuid+suffix);
				System.out.println(i.getId());
				System.out.println(url1+uuid+suffix);
				DynamicpictureService.insert(ii);
			}
			if(file3 != null) {
				System.out.println("s");
				String uuid = UUID.randomUUID().toString();
				String name = file1.getOriginalFilename();
				String suffix = name.substring(name.lastIndexOf("."), name.length());
				File fileImg = new File(url+uuid+suffix);
				file1.transferTo(fileImg);
				Dynamicpicture ii = new Dynamicpicture();
				ii.setDyid(i.getId());
				ii.setUrl(url1+uuid+suffix);
				System.out.println(i.getId());
				System.out.println(url1+uuid+suffix);
				DynamicpictureService.insert(ii);
			}
		
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "新增成功";
	}
}
