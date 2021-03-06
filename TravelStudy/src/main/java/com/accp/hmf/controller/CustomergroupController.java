package com.accp.hmf.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.Customergroup;
import com.accp.domain.Customerss;
import com.accp.domain.Employee;
import com.accp.domain.Plate;
import com.accp.hmf.service.CustomerService;
import com.accp.hmf.service.CustomergroupService;
import com.accp.qyj.service.PlateService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/customergroup")
public class CustomergroupController {
	@Autowired
	CustomergroupService cgs;
	@Autowired
	CustomerService cs;

	@Autowired
    HttpServletResponse response;
	@Autowired
	PlateService plateservice;

	
	 
	 @RequestMapping("/customergroupdeleteall")
	 @ResponseBody
	 public int customergroupdeleteall(@RequestBody Customergroup customergroup) {
		 List<Customergroup> list=customergroup.getMlist();
		 for (Customergroup customergroup2 : list) {
			 cgs.deleteByPrimaryKey(customergroup2.getId());
			 cs.delbygroupid(customergroup2.getId());
		}
		 return 0;
	 }
	 
	 //客户组更新
	 @RequestMapping("/groupupdate")
	 public String groupupdate(Customergroup customergroup) {
		 

	
		 String username=customergroup.getFzr();
		 Customerss customerss1=cs.cuqueryusername(username);
		 if(customerss1!=null) {
			 Customerss customerss=cs.cuqueryd(customergroup.getFid());
			 customerss.setSpare1("普通客户");
			 cs.updateByPrimaryKeySelective(customerss);
			 customerss1.setSpare1("负责人");
			 cs.updateByPrimaryKeySelective(customerss1);
			 customergroup.setFid(customerss1.getId());
			 cgs.updateByPrimaryKeySelective(customergroup);
			 
			 response.setCharacterEncoding("UTF-8");
		     	response.setContentType("text/html; charset=utf-8");
		     	PrintWriter out;
		 		try {
		 			out = response.getWriter();
		 			out.println("<script>");
		 		    out.println("alert('修改成功！');");
		 		    out.println("var index=parent.layer.getFrameIndex(window.name);");
		 		    out.println("parent.layer.close(index)");
		 		    out.println("window.parent.location.reload();");
		 		   
		 		  
		 		    
		 		    out.println("</script>");
		 		} catch (IOException e) {
		 			// TODO Auto-generated catch block
		 			e.printStackTrace();
		 		}
		 		 return "member-user-update";
			 
		 }else {
			 response.setCharacterEncoding("UTF-8");
		     	response.setContentType("text/html; charset=utf-8");
		     	PrintWriter out;
		 		try {
		 			out = response.getWriter();
		 			out.println("<script>");
		 		    out.println("alert('没有此人，修改失败！');");
		 		    out.println("var index=parent.layer.getFrameIndex(window.name);");
		 		    out.println("parent.layer.close(index)");
		 		    out.println("window.parent.location.reload();");
		 		   
		 		  
		 		    
		 		    out.println("</script>");
		 		} catch (IOException e) {
		 			// TODO Auto-generated catch block
		 			e.printStackTrace();
		 		}
		 		 return "member-user-update";
			 
			 
		 }
		 
		
		
	 }
	 
	 //客户组更新页面
	 @RequestMapping("/togroupupdate")
	 public String togroupupdate(Model model,Integer id) {
		 Customergroup customergroup=cgs.groupname(id);
		 Customerss customerss=cs.cuqueryd(customergroup.getFid());
		 customergroup.setFzr(customerss.getUsername());
		 model.addAttribute("customergroup", customergroup);
		 
		 return "member-user-update";
	 }
	
	 @RequestMapping("/tousergroupquery")
	 public String tousergroupquery() {
		 
		 return "member-usergroup-query";
	 }
	 
	  @RequestMapping("/dr")
		public String dr(MultipartFile file,String groupname) {
		  Customergroup customergroup=new Customergroup();
		  customergroup.setGroupname(groupname);
		  customergroup.setFid(0);
		  cgs.insertSelective(customergroup);
		 
		  SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
	    	 Integer year=Integer.parseInt(df.format(new Date()));
			try {
				
				XSSFWorkbook workbook=new XSSFWorkbook(file.getInputStream());
		       Sheet sheet= workbook.getSheetAt(0);	
		      int rows=sheet.getPhysicalNumberOfRows();
		      for (int i = 1; i < rows; i++) {
		    	  Customerss customerss=new Customerss();
				  org.apache.poi.ss.usermodel.Row row=sheet.getRow(i);
				  Cell id= row.getCell(0);
				  Double ids= id.getNumericCellValue();
//				  int x=ids.intValue();
				  
				   Cell name=row.getCell(1);
				   String username= name.getStringCellValue();
				   
				   Cell sex1=row.getCell(2);
				   String sex= sex1.getStringCellValue();
				   
				   Cell idcard1=row.getCell(3);
				   String idcard= idcard1.getStringCellValue();
				 
				   
				   
				   Cell phone1=row.getCell(4);
				 
				
				  
				   String phone=phone1.getStringCellValue();
				   
				   Cell email1=row.getCell(5);
				   String email= email1.getStringCellValue();
				   
				   Cell address1=row.getCell(6);
				   String address= address1.getStringCellValue();
				   
				   Cell spare=row.getCell(7);
				   String spare1= spare.getStringCellValue();
				   
				   
		
				   
				   if(spare1.equals("负责人")) {
					   
					   customerss.setUsername(username);
					   customerss.setUserpassword("123456");
					   customerss.setEmail(email);
					   customerss.setSex(sex);
					   customerss.setPhone(phone);
					   customerss.setAddress(address);
					   customerss.setCreatetime(new Date());
					   customerss.setConsumption(0.0);
					   customerss.setConsume(0);
					   customerss.setIdcard(idcard);
					   customerss.setState(1);
					   customerss.setGroupid(customergroup.getId());
					   customerss.setSpare1(spare1);
					   Integer nl=Integer.parseInt(idcard.substring(6, 10));
				    	 Integer nl1=year-nl;
				    	 
				    	 customerss.setSpare2(nl1.toString());
				    	 cs.insertSelective(customerss);
				    	 
				    	 Customergroup customergroup2=new Customergroup();
				    	 customergroup2.setId(customergroup.getId());
				    	 customergroup2.setFid(customerss.getId());
				    	 cgs.updateByPrimaryKeySelective(customergroup2);
					   
				   }else {
					   
					   customerss.setUsername(username);
					   customerss.setUserpassword("123456");
					   customerss.setEmail(email);
					   customerss.setSex(sex);
					   customerss.setPhone(phone);
					   customerss.setAddress(address);
					   customerss.setCreatetime(new Date());
					   customerss.setConsumption(0.0);
					   customerss.setConsume(0);
					   customerss.setIdcard(idcard);
					   customerss.setState(1);
					   customerss.setGroupid(customergroup.getId());
					   customerss.setSpare1(spare1);
					   Integer nl=Integer.parseInt(idcard.substring(6, 10));
				    	 Integer nl1=year-nl;
				    	 
				    	 customerss.setSpare2(nl1.toString());
				    	 cs.insertSelective(customerss);
					   
				   }
				   
				   
				   

			   }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			response.setCharacterEncoding("UTF-8");
	        	response.setContentType("text/html; charset=utf-8");
	        	PrintWriter out;
	    		try {
	    			out = response.getWriter();
	    			out.println("<script>");
	    		    out.println("alert('客户录入成功！');");
	    		    out.println("var index=parent.layer.getFrameIndex(window.name);");
	    		    out.println("parent.layer.close(index)");
	    		    out.println("window.parent.location.reload();");
	    		   
	    		  
	    		    
	    		    out.println("</script>");
	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
			
			
			return "member-usergroup";
		}
	
	
	@RequestMapping("/mb")
	public ResponseEntity<byte[]> mb() {
		 org.springframework.http.HttpHeaders hea=new org.springframework.http.HttpHeaders();
		 byte [] bytes = null;
		 try {
			FileInputStream f=new FileInputStream("D:\\fileupload\\模板.xlsx");
			bytes=new byte[f.available()];
			f.read(bytes);
			 
			  hea.setContentDispositionFormData("attacment", new String("客户模板.xlsx".getBytes("utf-8"),"iso-8859-1"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 hea.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		 return new ResponseEntity<byte[]>(bytes, hea, HttpStatus.OK);
	}
	
	@RequestMapping("/tocustomergroupadd")
	public String tocustomergroupadd() {
		return "member-usergroup-add";
	}
	
	@RequestMapping("/tocustomergroupquery")
	public String tocustomergroupquery(Model model , HttpSession session) {
		Employee es = (Employee)session.getAttribute("user");
		List<Plate> plate = plateservice.queryLeftNav(es.getId());
		model.addAttribute("plist", plate);
		return "member-usergroup";	
	}
	
	@RequestMapping("/customergroupquerypage")
	@ResponseBody
	 public  PageInfo<Customergroup> customergroupquerypage(Integer currentPage, Integer pageSize, String groupname) {
   	 if(currentPage==null) {
			   currentPage = 1;
		   }
		   PageInfo<Customergroup> pageInfo = cgs.querypage(currentPage,3,groupname);
//			model.addAttribute("page",pageInfo);
			
			return pageInfo;
   	
   	
   	
   }
   
	
	

}
