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
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/field")
public class FieldController {
        
	   @Autowired
	   FieldService fs;
	   
	   @RequestMapping("/fieldedit")
	   public String fieldedit(Field field) {
		   
		   fs.updateByPrimaryKeySelective(field);
		   
		   return "redirect:/field/tofieldquerypage";
	   }
	   
	   @RequestMapping("/tofieldedit")
	   public String tofieldedit(Model model,Integer id) {
		   Field field= fs.fqueryd(id);
		   model.addAttribute("field", field);
		   return "member-project-fieldedit";
	   }
	   
	   @RequestMapping("/fielddeletes")
	   public String fielddeletes(@RequestBody Field field) {
		   for (Field f : field.getMlist()) {
			fs.deleteByPrimaryKey(f.getId());
		}
		   
		   return "redirect:/field/tofieldquerypage";
	   }
	   
	     @RequestMapping("/fielddelete")
	     public String fielddelete(Integer id) {
	    	 
	    	 fs.deleteByPrimaryKey(id);
	    	 
	    	 return "redirect:/field/tofieldquerypage";
	     }
	   
	     @RequestMapping("/updatestate")
	     public String updatestate(Integer id,Integer occupy) {
	    	 Field field=new Field();
	    	 field.setId(id);
	    	 field.setOccupy(occupy);
	    	 fs.updateByPrimaryKeySelective(field);
	    	 
	    	 return "redirect:/field/tofieldquerypage";
	     }
	   
	     @RequestMapping("/fieldadd")
	     public String fieldadd(@RequestBody Fieldtype fieldtype) {
	    	 fs.insertSelective(fieldtype);
	    	
	    	 for (Field f : fieldtype.getFlist()) {
				f.setTid(fieldtype.getId());
				f.setOccupy(0);
				fs.insertSelective(f);
			}
	    	 
	    	 
	    	 return "redirect:/field/tofieldquerypage";
	     }
	     
	      @RequestMapping("/tofieldadd")
	      public String tofieldadd() {
	    	  return "member-project-fieldadd";
	      }
	   
	   
	     @RequestMapping("/tofieldquerypage")
	     public String tofield() {
	    	 return "member-project-field";
	     }
	     
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
