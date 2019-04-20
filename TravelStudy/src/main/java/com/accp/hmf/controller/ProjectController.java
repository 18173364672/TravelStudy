package com.accp.hmf.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.Employee;
import com.accp.domain.Field;
import com.accp.domain.Fieldtype;
import com.accp.domain.Project;
import com.accp.domain.Projectimg;
import com.accp.hmf.service.EmployeeService;
import com.accp.hmf.service.FieldService;
import com.accp.hmf.service.ProjectService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	ProjectService ps;
	@Autowired
	FieldService fs;
	@Autowired
	EmployeeService em;
	
	
	@RequestMapping("/toprojectimg")
	public String toprojectimg() {
		return "member-project-img";
	}
	
	@RequestMapping("/projectimg")
	@ResponseBody
	public List<Projectimg> projectimg(Integer id) {
		List<Projectimg> list=ps.queryimg(id);
		
		
		return list;
	}
	
	
	@RequestMapping("/projectadd")
	@ResponseBody
	public int projectadd(@RequestBody Project project) {
		List<Employee> emlist=project.getEmlist();
		String ids="";
		for (Employee employee : emlist) {
			ids+=employee.getId()+",";
		}
		
		String ids1="";
		List<Field> flist=project.getFlist();
		for (Field field : flist) {
		   ids1+=field.getId()+",";
		}
	    Fieldtype type=fs.queryfname(Integer.parseInt(project.getType()));
	    project.setType(type.getName());
		project.setIds(ids);
		project.setIds1(ids1);
		ps.insertSelective(project);
	
		
		
		return project.getId();
	}
	
	 @RequestMapping("/fileupload")
	 @ResponseBody
	   public String fileUpload(MultipartFile []file,Integer pid) {
		  System.out.println(pid);
		  
		   String url="E:\\file\\";
		   
		   File filepath=new File(url);
		   if(!filepath.exists()) {
			   filepath.mkdirs();
		   }
		  
		     try {
		    	 for (MultipartFile f : file) {
		    		 String uuid=UUID.randomUUID().toString();
					   String name=f.getOriginalFilename();
					   String filename=name.substring(name.lastIndexOf("."), name.length());
					  File img=new File(url+name);
					  Projectimg projectimg=new Projectimg();
					  projectimg.setImg(name);
					  projectimg.setProjectid(pid);
					  ps.insertSelective(projectimg);
					f.transferTo(img);
					
				}
		    	
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   return "ok";
	   }
	
	
	@RequestMapping("/querycd")
	@ResponseBody
	public List<Field> querycd(Model model,Integer tid){
		List<Field> flist=fs.fquerycd(tid);
		model.addAttribute("flist", flist);
		
		return flist;
	}
	
	@RequestMapping("/queryjl")
	@ResponseBody
	public List<Employee> queryjl(Integer fid) {
		Fieldtype fieldtype=fs.queryfname(fid);
		String job=fieldtype.getName();
		List<Employee> elist=em.queryjl(job);
		
		return elist;
	}
	
	@RequestMapping("/toprojectadd")
	public String toprojectadd(Model model,String name) {
		
		List<Fieldtype> list=fs.selectByExample(null);
		model.addAttribute("list", list);
		return "member-project-add";
	}
	
	@RequestMapping("/projectquerypage")
	@ResponseBody
	 public PageInfo<Project> querypage(Integer currentPage,String projectname){
   	 if(currentPage==null) {
			   currentPage = 1;
		   }
   	 
   	 PageInfo<Project> pageInfo=ps.querypage(currentPage, 3, projectname);
   	    return pageInfo;
    }
	
	
	@RequestMapping("/toprojectquerypage")
	public String toprojectquerypage() {
		
		return "member-project";
	}
	

}
