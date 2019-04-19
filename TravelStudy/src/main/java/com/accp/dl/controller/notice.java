package com.accp.dl.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.poi.sl.usermodel.TextParagraph.BulletStyle;
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
import com.accp.domain.Noticesecond;
import com.accp.domain.Organization;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;
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
	public PageInfo<Employee> employeeQuery(Model model,Integer currentPage,String employeename,Integer pageSize) {
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
		Notice dueix = notices.queryAll();
		noticesecond.toAdd(dueix.getId());
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
//				System.out.println(chang);
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
	
	/**
	 * 按员工发送信息
	 * @param title
	 * @param content
	 * @param uid
	 * @param spare1
	 * @return
	 */
	@RequestMapping("toAdd")
	@ResponseBody
	public String toAdd(String title ,String content,Integer uid,String spare1[]) {
		for (int i = 0; i < spare1.length; i++) {
			notices.toAdd(title, content, 1, spare1[i]);
		}
		return "redirect:member";
	}
	
	/**
	 * 跳转已发送信息员工信息
	 * @return
	 */
	@RequestMapping("/Myemployee")
	public String Myemployee() {
		
		return "DanFaBu";
	}
	
	/**
	 * 消息分页查询
	 * @param model
	 * @param currentPage
	 * @param title
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/noticeQuery")
	@ResponseBody
	public PageInfo<Notice> noticeQuery(Model model,Integer currentPage,String title,Integer pageSize) {
		if (currentPage == null) {
			currentPage=1;
		}
		if (title==null) {
			title ="";
		}
		PageInfo<Notice> pageList = notices.selecQueryFeYue(currentPage,title, 5);
		return pageList;
	}
	
	
	
	
	
	
	/**
	 * 详情
	 * @return
	 */
	@RequestMapping("/xiangQing")
	public String xiangQing(Integer LookIds,Model model) {
//		System.out.println(LookIds+"这是有没有!!!");
		if (LookIds!=null) {
			Notice dueix = notices.selectById(LookIds);
			if (dueix.getSpare1()==null) {
//				System.out.println(dueix.getUid());
//				String rid = dueix.getSpare1();
				Noticesecond cdueix = noticesecond.selectById(LookIds);
//				cdueix.getRid();
//				System.out.println(cdueix.getRid());
				Organization odueix2 =  orgainzation.selectById(cdueix.getRid());
				model.addAttribute("rid",odueix2);
				return "gGao";
			}
			int eid = Integer.parseInt(dueix.getSpare1());
			Employee edueix = employee.selectById(eid);
//			Noticesecond cdueix = noticesecond.selectById(dueix.getUid());
			int oid = Integer.parseInt(edueix.getSpare1());
			Organization odueix =  orgainzation.selectById(oid);
			
//			System.out.println(dueix.getTitle()+"标题!!!");
//			System.out.println(edueix.getEmployeename()+"名称!!!");
//			System.out.println(odueix.getName()+"部门!!!");
			
			model.addAttribute("dueix",dueix);		//公告内容
			model.addAttribute("edueix",edueix);	//员工姓名
			model.addAttribute("odueix",odueix);	//部门名称
		}
		return "FaBu";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
