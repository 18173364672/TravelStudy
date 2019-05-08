package com.accp.hmf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ssi.ByteArrayServletOutputStream;
import org.apache.http.HttpResponse;
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

import com.accp.hmf.service.CustomerService;
import com.accp.hmf.service.CustomergroupService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService cs;
    @Autowired
    CustomergroupService cgs;
    @Autowired
    HttpServletResponse response;
    
    
    //客户信息
    @RequestMapping("/tocustomershow")
    public String tocustomershow() {
    	return "member-show";
    }
    
    //客户反馈页面
    @RequestMapping("/tocustomerfeedback")
    public String tocustomerfeedback() {
    	
    	return "member-feedback";
    }
    
    //活动通知页面
    @RequestMapping("/tocustomerhdtz")
    public String tocustomerhdtz() {
    	
    	return "member-kiss";
    }
    
    //活动推荐页面
    @RequestMapping("/tocustomerhdtj")
    public String tocustomerhdtj() {
    	
    	return "member-level";
    }
    
    @RequestMapping("/customerdeletes")
    public String customerdelete(Integer id) {
 		cs.deleteByPrimaryKey(id);
 	   
 	   
 		return "redirect:/customer/tomemberdel";
    }
       
       
       @RequestMapping("/customerdelete")
       public String customerdelete(@RequestBody Customerss customerss) {
    		for (Customerss c : customerss.getMlist()) {
				cs.deleteByPrimaryKey(c.getId());
			}
    	   
    	   
    		return "redirect:/customer/tomemberdel";
       }
    
       @RequestMapping("/tomemberdel")
       public String tomemberdel() { 
    	   return "member-del";
       }
       
       @RequestMapping("/customerquerypages")
       @ResponseBody
       public  PageInfo<Customerss> customerquerypages(Integer currentPage, Integer pageSize, String createtime, String username) {
       	 if(currentPage==null) {
   			   currentPage = 1;
   		   }
   		   PageInfo<Customerss> pageInfo = cs.querypages(currentPage,3,createtime,username);
//   			model.addAttribute("page",pageInfo);
   			
   			return pageInfo;
       	
       	
       	
       }
       
    
       @RequestMapping("/dc")
	   public ResponseEntity<byte[]> dc(String groupname) {
		   if(groupname.equals("全部")) {
			   List<Customerss> list=cs.dcall();
			   XSSFWorkbook workbook=new XSSFWorkbook();
			   Sheet sheet= workbook.createSheet("我的sheet");
			   org.apache.poi.ss.usermodel.Row row0=sheet.createRow(0);
			   Cell cell=row0.createCell(0);
			   cell.setCellValue("编号");
			   Cell cell1=row0.createCell(1);
			   cell1.setCellValue("姓名");
			   Cell cell2=row0.createCell(2);
			   cell2.setCellValue("性别");
			   Cell cell3=row0.createCell(3);
			   cell3.setCellValue("年龄");
			   Cell cell4=row0.createCell(4);
			   cell4.setCellValue("身份证");
			   Cell cell5=row0.createCell(5);
			   cell5.setCellValue("手机");
		
			   Cell cell6=row0.createCell(6);
			   cell6.setCellValue("邮箱");
			   Cell cell7=row0.createCell(7);
			   cell7.setCellValue("地址");
			   Cell cell8=row0.createCell(8);
			   cell8.setCellValue("团体组");
			   Cell cell9=row0.createCell(9);
			   cell9.setCellValue("客户类型");
			   
			   
			   for(int i=0;i<list.size();i++) {
				   org.apache.poi.ss.usermodel.Row row=sheet.createRow(i+1);
				   Cell id=row.createCell(0);
				   id.setCellValue(list.get(i).getId());
				   
				   Cell username=row.createCell(1);
				   username.setCellValue(list.get(i).getUsername());
				   
				   Cell sex=row.createCell(2);
				   sex.setCellValue(list.get(i).getSex());
				   
				   Cell spare2=row.createCell(3);
				   spare2.setCellValue(list.get(i).getSpare2());
				   
				   Cell idcard=row.createCell(4);
				   idcard.setCellValue(list.get(i).getIdcard());
				   
				   Cell phone=row.createCell(5);
				   phone.setCellValue(list.get(i).getPhone());
				   
				   Cell email=row.createCell(6);
				   email.setCellValue(list.get(i).getEmail());
				   
				   Cell address=row.createCell(7);
				   address.setCellValue(list.get(i).getAddress());
				   
				   Cell groupnames=row.createCell(8);
				   if(list.get(i).getGroupid()>0) {
					   Customergroup customergroup=cgs.groupname(list.get(i).getGroupid());
					   groupnames.setCellValue(customergroup.getGroupname());
				   }else {
					   
					   groupnames.setCellValue("无");
				   }
				   
				   Cell spare1=row.createCell(9);
				   spare1.setCellValue(list.get(i).getSpare1());
				  
				   
				   
			   }
			   ByteArrayServletOutputStream bos=new ByteArrayServletOutputStream();
			   try {
				workbook.write(bos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   org.springframework.http.HttpHeaders hea=new org.springframework.http.HttpHeaders();
			   try {
				hea.setContentDispositionFormData("attacment", new String("导出的客户数据.xlsx".getBytes("utf-8"),"iso-8859-1"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   hea.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			   return new ResponseEntity<byte[]>(bos.toByteArray(), hea, HttpStatus.OK);
		   }else {
			   List<Customerss> list=cs.dcs(Integer.parseInt(groupname));
			   XSSFWorkbook workbook=new XSSFWorkbook();
			   Sheet sheet= workbook.createSheet("我的sheet");
			   org.apache.poi.ss.usermodel.Row row0=sheet.createRow(0);
			   Cell cell=row0.createCell(0);
			   cell.setCellValue("编号");
			   Cell cell1=row0.createCell(1);
			   cell1.setCellValue("姓名");
			   Cell cell2=row0.createCell(2);
			   cell2.setCellValue("性别");
			   Cell cell3=row0.createCell(3);
			   cell3.setCellValue("年龄");
			   Cell cell4=row0.createCell(4);
			   cell4.setCellValue("身份证");
			   Cell cell5=row0.createCell(5);
			   cell5.setCellValue("手机");
		
			   Cell cell6=row0.createCell(6);
			   cell6.setCellValue("邮箱");
			   Cell cell7=row0.createCell(7);
			   cell7.setCellValue("地址");
			   Cell cell8=row0.createCell(8);
			   cell8.setCellValue("团体组");
			   Cell cell9=row0.createCell(9);
			   cell9.setCellValue("客户类型");
			   
			   for(int i=0;i<list.size();i++) {
				   org.apache.poi.ss.usermodel.Row row=sheet.createRow(i+1);
				   Cell id=row.createCell(0);
				   id.setCellValue(list.get(i).getId());
				   
				   Cell username=row.createCell(1);
				   username.setCellValue(list.get(i).getUsername());
				   
				   Cell sex=row.createCell(2);
				   sex.setCellValue(list.get(i).getSex());
				   
				   Cell spare2=row.createCell(3);
				   spare2.setCellValue(list.get(i).getSpare2());
				   
				   Cell idcard=row.createCell(4);
				   idcard.setCellValue(list.get(i).getIdcard());
				   
				   Cell phone=row.createCell(5);
				   phone.setCellValue(list.get(i).getPhone());
				   
				   Cell email=row.createCell(6);
				   email.setCellValue(list.get(i).getEmail());
				   
				   Cell address=row.createCell(7);
				   address.setCellValue(list.get(i).getAddress());
				   
				   Cell groupnames=row.createCell(8);
				   if(list.get(i).getGroupid()>0) {
					   Customergroup customergroup=cgs.groupname(list.get(i).getGroupid());
					   groupnames.setCellValue(customergroup.getGroupname());
				   }else {
					   
					   groupnames.setCellValue("无");
				   }
				   
				   Cell spare1=row.createCell(9);
				   spare1.setCellValue(list.get(i).getSpare1());
				   
			   }
			   ByteArrayServletOutputStream bos=new ByteArrayServletOutputStream();
			   try {
				workbook.write(bos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   org.springframework.http.HttpHeaders hea=new org.springframework.http.HttpHeaders();
			   try {
				hea.setContentDispositionFormData("attacment", new String("导出的客户数据.xlsx".getBytes("utf-8"),"iso-8859-1"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   hea.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			   return new ResponseEntity<byte[]>(bos.toByteArray(), hea, HttpStatus.OK);
		   }
		   
		  
		  
	   }
	   
	 
	   @RequestMapping("/customerupstatess")
	    public String customerupstatess(@RequestBody Customerss customerss) {
	    	for (Customerss c : customerss.getMlist()) {
				c.setState(1);
				cs.updateByPrimaryKeySelective(c);
			}
	    	
	    	
	    	return "redirect:/customer/tomemberdel";
	    }
	   
    
    @RequestMapping("/customerupstates")
    public String customerupstates(Integer id) {
    	Customerss customerss=new Customerss();
    	customerss.setId(id);
    	customerss.setState(0);
    	cs.updateByPrimaryKeySelective(customerss);
    	
    	return "redirect:/customer/tocustomerquerypage";
    }
    
    @RequestMapping("/customerupstate")
    public String customerupstate(@RequestBody Customerss customerss) {
    	for (Customerss c : customerss.getMlist()) {
			c.setState(0);
			cs.updateByPrimaryKeySelective(c);
		}
    	
    	
    	return "redirect:/customer/tocustomerquerypage";
    }
    
    @RequestMapping("/customeredit")
    public String customeredit(Customerss customerss) {
    	
    	 SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
    	 Integer year=Integer.parseInt(df.format(new Date()));
    	 String idcard=customerss.getIdcard();
    	 
    	 Integer nl=Integer.parseInt(idcard.substring(6, 10));
    	 Integer nl1=year-nl;
    	 
    	 customerss.setSpare2(nl1.toString());
    	 
    		
    		
    		cs.updateByPrimaryKeySelective(customerss);
    	
    
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=utf-8");
    	PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<script>");
		    out.println("alert('修改成功！');");
		    out.println("history.back();");
		    out.println("var index=parent.layer.getFrameIndex(window.name);");
		    out.println("parent.layer.close(index)");
		    out.println("window.parent.location.reload();");
		    out.println("</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return "member-edit";
    	
    	
   
    }
   
    
    @RequestMapping("/tocustomeredit")
    public String tocustomeredit(Model model,Integer id) {
    	
    	List<Customergroup> list=cgs.selectByExample(null);
    	model.addAttribute("list", list);
    	
    	Customerss customerss=cs.cuqueryd(id);
    	
    	model.addAttribute("customerss", customerss);
    	return "member-edit";
    }
    
    @RequestMapping("/customeradd")
    public String customeradd(Customerss customerss) {
    	 Customergroup customergroup=new Customergroup();
    	  if(!customerss.getGroupname().equals("无")) {
    		  customergroup=cgs.groupname(Integer.parseInt(customerss.getGroupname()));
    	  }
    	
    	  if(customerss.getSpare1().equals("负责人")&&customerss.getGroupname().equals("无")) {
    			response.setCharacterEncoding("UTF-8");
            	response.setContentType("text/html; charset=utf-8");
            	PrintWriter out;
        		try {
        			out = response.getWriter();
        			out.println("<script>");
        		    out.println("alert('新增负责人失败，请选择团体组！');");
        		    out.println("var index=parent.layer.getFrameIndex(window.name);");
        		    out.println("parent.layer.close(index)");
        		    out.println("window.parent.location.reload();");
        		   
        		  
        		    
        		    out.println("</script>");
        		} catch (IOException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        		
        		
        
        	
        	return "member-add";
    	  }else if(customerss.getSpare1().equals("负责人")&&!customerss.getGroupname().equals("无")&&customergroup.getFid()>0){
    		
    		
    			
    			response.setCharacterEncoding("UTF-8");
            	response.setContentType("text/html; charset=utf-8");
            	PrintWriter out;
        		try {
        			out = response.getWriter();
        			out.println("<script>");
        		    out.println("alert('新增负责人失败，此团体已有负责人！');");
        		    out.println("var index=parent.layer.getFrameIndex(window.name);");
        		    out.println("parent.layer.close(index)");
        		    out.println("window.parent.location.reload();");
        		   
        		  
        		    
        		    out.println("</script>");
        		} catch (IOException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        		
        		
        
        	
        	
    			
    			
    	
    		  
    		return "member-add";
    		  
    	  }else if(customerss.getSpare1().equals("普通客户")){
    		  
    		  
    		  
    		  
    		  SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
    	    	 Integer year=Integer.parseInt(df.format(new Date()));
    	    	 String idcard=customerss.getIdcard();
    	    	 
    	    	 Integer nl=Integer.parseInt(idcard.substring(6, 10));
    	    	 Integer nl1=year-nl;
    	    	 
    	    	 customerss.setSpare2(nl1.toString());
    	    	 
    	        // new Date()为获取当前系统时间
    	    	
    	    	customerss.setCreatetime(new Date());
    	    	customerss.setConsumption(0.0);
    	    	customerss.setConsume(0);
    	    	customerss.setState(1);
    	    	
    	    	if(customerss.getGroupname().equals("无")) {
    	    		customerss.setGroupid(0);
    	    	}else {
    	    		
    	    		
    	    		customerss.setGroupid(Integer.parseInt(customerss.getGroupname()));
    	    	}
    	    	
    	    	int count=cs.insertSelective(customerss);
    	    	
    	    
    	    	
    	    		
    	    		response.setCharacterEncoding("UTF-8");
    	        	response.setContentType("text/html; charset=utf-8");
    	        	PrintWriter out;
    	    		try {
    	    			out = response.getWriter();
    	    			out.println("<script>");
    	    		    out.println("alert('新增客户成功！');");
    	    		    out.println("var index=parent.layer.getFrameIndex(window.name);");
    	    		    out.println("parent.layer.close(index)");
    	    		    out.println("window.parent.location.reload();");
    	    		   
    	    		  
    	    		    
    	    		    out.println("</script>");
    	    		} catch (IOException e) {
    	    			// TODO Auto-generated catch block
    	    			e.printStackTrace();
    	    		}
    	    		
    	    		
    	    
    	    	
    	    	return "member-add";
    		  
    		  
    		  
    	  }else {
    		  
    		  SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
 	    	 Integer year=Integer.parseInt(df.format(new Date()));
 	    	 String idcard=customerss.getIdcard();
 	    	 
 	    	 Integer nl=Integer.parseInt(idcard.substring(6, 10));
 	    	 Integer nl1=year-nl;
 	    	 
 	    	 customerss.setSpare2(nl1.toString());
 	    	 
 	        // new Date()为获取当前系统时间
 	    	
 	    	customerss.setCreatetime(new Date());
 	    	customerss.setConsumption(0.0);
 	    	customerss.setConsume(0);
 	    	customerss.setState(1);
 	    	
 	    
 	    		
 	    		
 	    		customerss.setGroupid(Integer.parseInt(customerss.getGroupname()));
 	    	
 	    	
 	    	int count=cs.insertSelective(customerss);
 	    	
 	    	Customergroup customergroup1=new Customergroup();
 	    	customergroup.setFid(customerss.getId());
 	    	customergroup.setId(Integer.parseInt(customerss.getGroupname()));
 	    	System.out.println(customergroup.getFid());
 	    	System.out.println(customergroup.getId());
 	    	int count1=cgs.updateByPrimaryKeySelective(customergroup);
 	    	
 	    		
 	    		response.setCharacterEncoding("UTF-8");
 	        	response.setContentType("text/html; charset=utf-8");
 	        	PrintWriter out;
 	    		try {
 	    			out = response.getWriter();
 	    			out.println("<script>");
 	    		    out.println("alert('新增负责人成功！');");
 	    		    out.println("var index=parent.layer.getFrameIndex(window.name);");
 	    		    out.println("parent.layer.close(index)");
 	    		    out.println("window.parent.location.reload();");
 	    		   
 	    		  
 	    		    
 	    		    out.println("</script>");
 	    		} catch (IOException e) {
 	    			// TODO Auto-generated catch block
 	    			e.printStackTrace();
 	    		}
 	    		
 	    		
 	    
 	    	
 	    	return "member-add";
 		  
    		  
    		  
    		  
    	  }
    	  
    	
    	
    	
    	
    }
    
    @RequestMapping("/tocustomeradd")
    public String tocustomeradd(Model model) {
    	List<Customergroup> list=cgs.selectByExample(null);
    	model.addAttribute("list", list);
    	
    	return "member-add";
    }
    
    @RequestMapping("/customerquerypage")
    @ResponseBody
    public  PageInfo<Customerss> customerquerypage(Integer currentPage, Integer pageSize, String createtime, String username) {
    	 if(currentPage==null) {
			   currentPage = 1;
		   }
		   PageInfo<Customerss> pageInfo = cs.querypage(currentPage,3,createtime,username);
//			model.addAttribute("page",pageInfo);
			
			return pageInfo;
    	
    	
    	
    }
    
    
    @RequestMapping("/tocustomerquerypage")
    public String tocustomerquerypage(Model model) {
    	
    	List<Customergroup> list=cgs.selectByExample(null);
    	model.addAttribute("list", list);
    	
    	return "member-list";
    }
	
}
