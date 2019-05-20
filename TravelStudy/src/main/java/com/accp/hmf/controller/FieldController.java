package com.accp.hmf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Field;
import com.accp.domain.Fieldtype;
import com.accp.hmf.service.FieldService;
import com.accp.hmf.service.FieldtypeService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/field")
public class FieldController {
        
	   @Autowired
	   FieldService fs;
	   @Autowired
	   FieldtypeService ffs;
	 
	   
	   //场地修改
	   @RequestMapping("/fieldedit")
	   public String fieldedit(Field field) {
		   
		   fs.updateByPrimaryKeySelective(field);
		   
		   return "redirect:/field/tofieldquerypage";
	   }
	   
	   
	   //跳转到场地修改页面
	   @RequestMapping("/tofieldedit")
	   public String tofieldedit(Model model,Integer id) {
		   Field field= fs.fqueryd(id);
		   model.addAttribute("field", field);
		   return "member-project-fieldedit";
	   }
	   
	   @RequestMapping("/fielddeletes")
	   public String fielddeletes(@RequestBody Field field) {
		   for (Field f : field.getMlist()) {
			   Field f1=fs.fqueryd(f.getId());   
			fs.deleteByPrimaryKey(f.getId());
			 int count=fs.fcount(f1.getTid());
			 if(count==0) {
		    		
	    		 ffs.deleteByPrimaryKey(f1.getTid());
	    	 }
		}
		   
		   return "redirect:/field/tofieldquerypage";
	   }
	   
	   
	   //场地删除
	     @RequestMapping("/fielddelete")
	     public String fielddelete(Integer id) {
	    	 Field field=fs.fqueryd(id);
	    	 fs.deleteByPrimaryKey(id);
	    	 int count=fs.fcount(field.getTid());
	    	 if(count==0) {
	    		
	    		 ffs.deleteByPrimaryKey(field.getTid());
	    	 }
	    	 
	    	 
	    	 return "redirect:/field/tofieldquerypage";
	     }
	   
	     
	     //更新场地状态
	     @RequestMapping("/updatestate")
	     public String updatestate(Integer id,Integer occupy) {
	    	 Field field=new Field();
	    	 field.setId(id);
	    	 field.setOccupy(occupy);
	    	 fs.updateByPrimaryKeySelective(field);
	    	 
	    	 return "redirect:/field/tofieldquerypage";
	     }
	   
	     
	     //场地添加
	     @RequestMapping("/fieldadd")
	     @ResponseBody
	     public int fieldadd(@RequestBody Fieldtype fieldtype) {
	    	 fs.insertSelective(fieldtype);
	    	
	    	 for (Field f : fieldtype.getFlist()) {
				f.setTid(fieldtype.getId());
				f.setOccupy(0);
				fs.insertSelective(f);
			}
	    	 
	    	 
	    	 return 0;
	     }
	     
	     
	     //跳转到场地添加页面
	      @RequestMapping("/tofieldadd")
	      public String tofieldadd() {
	    	  return "member-project-fieldadd";
	      }
	   
	   
	      
	      //跳转到场地信息页面
	     @RequestMapping("/tofieldquerypage")
	     public String tofield() {
	    	 return "member-project-field";
	     }
	     
	     
	     //场地信息分页
	     @RequestMapping("/fieldquerypage")
	     @ResponseBody
	     public PageInfo<Field> querypage(Integer currentPage,String name){
	    	 if(currentPage==null) {
				   currentPage = 1;
			   }
	    	 
	    	 PageInfo<Field> pageInfo=fs.querypage(currentPage, 6, name);
	    	 return pageInfo;
	     }
	
}
