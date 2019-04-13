package com.accp.dl.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.xml.resolver.apps.resolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.accp.dl.service.impl.employeeServiceImpl;
import com.accp.dl.service.impl.noticeServiceImpl;
import com.accp.dl.service.impl.noticepictureServiceImpl;
import com.accp.dl.service.impl.noticesecondServiceImpl;
import com.accp.dl.service.impl.orgainizationServiceImpl;
import com.accp.domain.Employee;
import com.accp.domain.Notice;
import com.accp.domain.Noticepicture;
import com.accp.domain.Organization;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.Module;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/notice")
public class notice {

	
	@Autowired
	noticeServiceImpl notices;
	
	@Autowired
	orgainizationServiceImpl orgainzation;
	
	@Autowired
	noticepictureServiceImpl noticepicture;
	
	@Autowired
	noticesecondServiceImpl noticesecond;
	
	
	@Autowired
	employeeServiceImpl employee;
	
	
	/**
	 * 开始的主页
	 * @return
	 */
	@RequestMapping("/query")
	public String index() {
		return "index";
	}
	
	/**
	 * 跳转公告管理
	 * @return
	 */
	@RequestMapping("/member")
	public String member() {
		return "member-employee-kiss";
	}
	
	/**
	 * 跳转全公司发送
	 * @return
	 */
	@RequestMapping("/company")
	public String company() {
		return "member-employee-kiss-company";
	}
	
	/**
	 * 跳转员工发送
	 * @return
	 */
	@RequestMapping("/employee")
	public String employee() {

		return "member-employee-kiss-employee";
	}
	
	
	/**
	 * 员工查询
	 * @return
	 */
	@RequestMapping("/employeeQuery")
	@ResponseBody
	public PageInfo employeeQuery(Model model,Integer currentPage,String employeename,Integer pageSize) {
//		List<Employee> list = employee.selectByExample(null);
		if (currentPage == null) {
			currentPage=1;
		}
		if (employeename==null) {
			employeename ="";
		}
		PageInfo<Employee> pageList = employee.selecQueryFeYue(currentPage,employeename, 5);
		
//		System.out.println(pageList.getList().get(0).getSpare1());
//		
//		model.addAttribute("pageList",pageList);
//		model.addAttribute("employeename",employeename);
		
		return pageList;
	}
	
	
	
	
	/**
	 * 跳转部门发送
	 * @return
	 */
	@RequestMapping("/organization")
	public String organization(Model Model) {
		List<Organization> list = orgainzation.selectByExample(null);
		Model.addAttribute("list",list);
		return "member-employee-kiss-organization";
	}
	
	
	/**
	 * 群发公司所有员工
	 * @param notice
	 * redirect:
	 * @return
	 */
	@RequestMapping("/addnotice")
	@ResponseBody
	public String addnotice(String title ,String content,Integer uid) {
		notices.add(title, content, 1);
		return "kkkk";
	}
	
	/**
	 * 群发公司所有部门
	 * @return
	 */
	@RequestMapping("/addBuMen")
	@ResponseBody
	public String addBuMen(String title ,String content,Integer uid,Integer rid,MultipartFile file) {
		notices.add(title, content, 1);
		Notice stu = notices.selectOrderBy();
		int nid = stu.getId();
		String url = "D:\\Fileupload\\";
		File files = new File(url);
		if (!files.exists()) {
			files.mkdirs();
		}
		try {
				String uuid = UUID.randomUUID().toString();
				String name = file.getOriginalFilename();
				String suffix = name.substring(name.lastIndexOf("."),name.length());
				File chang = new File(url+uuid+suffix);
				file.transferTo(chang);
				String urls = chang.toString();
				noticepicture.addinsert(urls);	//新增图片
				
				Noticepicture stus = noticepicture.selectOrderBy();
				int iid = stus.getId();
				
				noticesecond.addNoticesecound(rid, iid, nid);
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:member";
	}
	
//	/**
//	 * 查询所有的部门及部门里的员工
//	 * @return
//	 */
//	@RequestMapping("/selectQuery")
//	@ResponseBody
//	public List<Employee> selectQuery() {
//		List<Employee> list = employee.selectByExample(null);
////		List<Organization> list1 = orgainzation.selectByExample(null);
////		model.addAttribute("list",list);
////		model.addAttribute("list1",list1);
//		return list;
//	}
	
	
	
	
	
}
