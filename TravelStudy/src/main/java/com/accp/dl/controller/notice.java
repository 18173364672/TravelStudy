package com.accp.dl.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.poi.sl.usermodel.TextParagraph.BulletStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.accp.dl.handler.webSocketHandler;
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
import com.accp.domain.Plate;
import com.accp.qyj.service.PlateService;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/notice")
//@MultipartConfig 
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
	
	@Autowired
	PlateService plateservice;
	
	
	@Autowired
	webSocketHandler webSocke;
	
//	/**
//	 * 测试
//	 * @return
//	 */
//	@RequestMapping("/Text")
//	public String Text() {
//		return "测试";
//	}
	
	
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
	public String member(Model model , HttpSession session) {
		Employee es = (Employee)session.getAttribute("user");
		List<Plate> plate = plateservice.queryLeftNav(es.getId());
		model.addAttribute("plist", plate);
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
	 * 员工查询
	 * @return
	 */
	@RequestMapping("/MyBuMen")
	@ResponseBody
	public List<Organization> MyBuMen() {
//		System.out.println("进来了");
		List<Organization> list = orgainzation.selectByExample(null);
		return list;
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
	public String addnotice(String title ,String content,MultipartFile file , HttpSession session) {
		Employee user = (Employee)session.getAttribute("user");
		notices.add(title, content, user.getId());			//缺少登录的id
		Notice dueix = notices.queryAll();
		noticesecond.toAdd(dueix.getId());
		Notice stu = notices.selectOrderBy();
		int nid = stu.getId();
		
		String url = "D:\\Fileuploads\\";
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
				noticepicture.addinsert(urls);	//新增图片文件
				Noticepicture stus = noticepicture.selectOrderBy();
				int iid = stus.getId();
				
				noticesecond.addNoticesecound(-1, iid, nid);
				
				
				List<Employee> list = employee.selectByExample(null);
				System.out.println("内容为:"+content);
				
				String [] id = new String[list.size()];
				
				for (int j = 0; j < id.length; j++) {
					id[j] = dueix.getId().toString();
					webSocke.sendMsg(content,id[j]);  	//webSocke 调用了方法
				}
//				for (Employee ds : list) {
//					webSocke.sendMsg(content,ds.getId().toString());  	//webSocke 调用了方法
//				}
//				
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:member";
	}
	
	/**
	 * 群发公司部门
	 * @return
	 */
	@RequestMapping("/addBuMen")
	@ResponseBody
	public String addBuMen(String title ,String content, HttpSession session,Integer rid,MultipartFile file) {
		Employee user = (Employee)session.getAttribute("user");
		notices.add(title, content, user.getId());			//缺少登录的id
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
				
				
//				Employee dueix = employee.selectById(Integer.parseInt(spare1[i]));
//				System.out.println("内容为:"+content);
//				
//				webSocke.sendMsg(content,dueix.getId().toString());  	//webSocke 调用了方法
				
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
	public String toAdd(String title ,String content, HttpSession session,String spare1[],MultipartFile file) {
		Employee user = (Employee)session.getAttribute("user");
		for (int i = 0; i < spare1.length; i++) {
			notices.toAdd(title, content, user.getId(), spare1[i]);			//缺少登录的id
			
			Notice stu = notices.selectOrderBy();
			int nid = stu.getId();
			String url = "D:\\Fileuploads\\";
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
//					System.out.println(chang+"路径");
					String urls = chang.toString();
					noticepicture.addinsert(urls);	//新增图片文件
					
					Noticepicture stus = noticepicture.selectOrderBy();
					int iid = stus.getId();
					
					noticesecond.addNoticesecound(0, iid, nid);
					
//					Employee dueix = employee.selectById(Integer.parseInt(spare1[i]));
//					System.out.println("内容为:"+content);
//					
//					webSocke.sendMsg(content,dueix.getId().toString());  	//webSocke 调用了方法
					
					String [] id = new String[spare1.length];
					
					Employee dueix = employee.selectById(Integer.parseInt(spare1[i]));
					System.out.println("内容为:"+content);
					for (int j = 0; j < id.length; j++) {
						id[j] = dueix.getId().toString();
						webSocke.sendMsg(content,id[j]);  	//webSocke 调用了方法
					}
					
			}catch (Exception e) {
				e.printStackTrace();
			}
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
//			if (dueix.getSpare1()==null) {
////				System.out.println(dueix.getUid());
////				String rid = dueix.getSpare1();
////				Noticesecond cdueix = noticesecond.selectById(LookIds);
////				cdueix.getRid();
////				System.out.println(cdueix.getRid());
////				Organization odueix2 =  orgainzation.selectById(cdueix.getRid());
////				model.addAttribute("rid",odueix2);
//				return "gGao";
//			}
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
	
	
	/**
	 * 部门或全公司公告
	 * @return
	 */
	@RequestMapping("BuMen")
	public String BuMen() {
//		System.out.println("进来了!!");
		return "BuMen";
	}
	
	
	/**
	 * 个人消息分页查询
	 * @param model
	 * @param currentPage
	 * @param title
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/MynoticeQuery")
	@ResponseBody
	public PageInfo<Notice> MynoticeQuery(Model model,Integer currentPage, HttpSession session,String title,Integer pageSize,Integer uid) {
		Employee user = (Employee)session.getAttribute("user");
//		System.out.println("进来了!!");
		
		if (currentPage == null) {
			currentPage=1;
		}
		if (title==null) {
			title ="";
		}
//		String spare = uid.toString();
		PageInfo<Notice> pageList = notices.Myquery(currentPage,title, 5,user.getId().toString());
		return pageList;
	}
	
	/**
	 * 详情
	 * @return
	 */
	@RequestMapping("/GeRenxiangQing")
	public String GeRenxiangQing(Integer LookIds,Model model) {
		System.out.println(LookIds);
		Notice dueix = notices.selectById(LookIds);
		int eid = Integer.parseInt(dueix.getSpare1());
		Employee edueix = employee.selectById(eid);
		int oid = Integer.parseInt(edueix.getSpare1());
		Organization odueix =  orgainzation.selectById(oid);
		Noticesecond dueixWen = noticesecond.selectById(LookIds);
		Noticepicture dueixTuPian = noticepicture.selectById(dueixWen.getIid());
		
		model.addAttribute("dueix",dueix);		//公告内容
		model.addAttribute("edueix",edueix);	//员工姓名
		model.addAttribute("odueix",odueix);	//部门名称
		model.addAttribute("dueixTuPian",dueixTuPian);	//图片文件
		
		return "GeRen";
	}
	
	
	
	
	
}
