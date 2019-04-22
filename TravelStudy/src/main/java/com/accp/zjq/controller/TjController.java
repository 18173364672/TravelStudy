package com.accp.zjq.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.cxf.binding.soap.Soap11;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.ActivityTwo;
import com.accp.domain.Employee;
import com.accp.domain.MonthOrder;
import com.accp.domain.MonthOrderTwo;
import com.accp.domain.MonthSr;
import com.accp.domain.MonthSrTwo;
import com.accp.domain.MydAndName;
import com.accp.domain.Plate;
import com.accp.domain.Project;
import com.accp.domain.ProjectByTimeAndName;
import com.accp.domain.ProjectNameAndRenqi;
import com.accp.domain.QuestionTj;
import com.accp.domain.QuestionTwo;
import com.accp.qyj.service.PlateService;
import com.accp.zjq.service.ActivityService;
import com.accp.zjq.service.OrderService;
import com.accp.zjq.service.ProjectService;
import com.accp.zjq.service.UserprojectdiscussService;
import com.fasterxml.jackson.core.sym.Name;
import com.mysql.cj.conf.StringProperty;

@Controller
public class TjController {

	@Autowired
	ProjectService psi;
	
	@Autowired
	OrderService osi;
	
	@Autowired
	ActivityService asi;
	
	@Autowired
	UserprojectdiscussService usi;
	
	@Autowired
	PlateService plateservice;

	@RequestMapping("/toRqProject")
	public String toRqProject(Model model, HttpSession session) {
		Employee es = (Employee)session.getAttribute("user");
		List<Plate> plate = plateservice.queryLeftNav(es.getId());
		model.addAttribute("plist", plate);
		System.out.println("加载项目人气页面中...");
		List<MonthOrder>monthOrders2 = osi.SelectOrYears();
		model.addAttribute("years", monthOrders2);
		return "echarts1";
	}

	@RequestMapping("/ajaxToQuery")
	@ResponseBody
	public 	List<ProjectNameAndRenqi>  ajaxToQuery(String years) {
		System.out.println("years:"+years);
//		人气
		List<ProjectNameAndRenqi> dataList= new ArrayList<>();
		
		List<ProjectByTimeAndName> projectByTimeAndNames = psi.superSelectProject(years);
		Map<String , String> nameMap = new HashMap<>();
		for (ProjectByTimeAndName projectByTimeAndName : projectByTimeAndNames) {
			if(nameMap.containsKey(projectByTimeAndName.getProjectname())) {
				continue;
			}
			
			nameMap.put(projectByTimeAndName.getProjectname(), "已有");
			
			ProjectNameAndRenqi projectNameAndRenqi = new ProjectNameAndRenqi();
			
			projectNameAndRenqi.setName(projectByTimeAndName.getProjectname());		
			
			for (ProjectByTimeAndName projectByTimeAndName2 : projectByTimeAndNames) {
				
				if(projectByTimeAndName2.getProjectname().equals(projectNameAndRenqi.getName())) {
				
					Integer month = Integer.valueOf(projectByTimeAndName2.getMonths().substring(4));
					
					System.out.println(month);
					
					int [] renqi= projectNameAndRenqi.getRenqi();
					
					renqi[month-1] = projectByTimeAndName2.getRenQi();
					
					projectNameAndRenqi.setRenqi(renqi);
				}
			}
			dataList.add(projectNameAndRenqi);
		}
		return dataList;
	}

	@RequestMapping("toMonthSr")
	public String toMonthSr(Model model , HttpSession session) {
		Employee es = (Employee)session.getAttribute("user");
		List<Plate> plate = plateservice.queryLeftNav(es.getId());
		model.addAttribute("plist", plate);
		System.out.println("正在加载每月收入...");
		List<MonthOrder>monthOrders2 = osi.SelectOrYears();
		model.addAttribute("years", monthOrders2);
		return "echarts2";
	}
	
	@RequestMapping("toAjaxQueryMonthSr")
	@ResponseBody
	public int[] toAjaxQueryMonthSr(String years) {
		int[] sumprice = {0,0,0,0,0,0,0,0,0,0,0,0};
		List<MonthSr>monthSrs = osi.selectMonthSr(years);
		for (MonthSr monthSr : monthSrs) {
			Integer month = Integer.valueOf(monthSr.getMonths());
			System.out.println("月份:"+month);
			System.out.println("数量"+monthSr.getSumprice());
			sumprice[month-1]=monthSr.getSumprice();
		}
		
		
		return sumprice ;
	}

	@RequestMapping("toRqTeacher")
	public String toRqTeacher(Model model , HttpSession session) {
		Employee es = (Employee)session.getAttribute("user");
		List<Plate> plate = plateservice.queryLeftNav(es.getId());
		model.addAttribute("plist", plate);
		List<MydAndName>mydAndNames = usi.selectByMyd();
		
		model.addAttribute("mydAndNames", mydAndNames);
		
		return "echarts3";
	}
	
	@RequestMapping("toAjaxMyd")
	@ResponseBody
	public List<MydAndName> toAjaxMyd(){
		List<MydAndName>mydAndNames = usi.selectByMyd();
		return mydAndNames;
	}
	
	@RequestMapping("toAjaxMyd2")
	@ResponseBody
	public String[] toAjaxMyd2() {
		List<MydAndName>MydAndNames = usi.selectByMyd();
		String [] names = new String[MydAndNames.size()];
			for (int i = 0; i < MydAndNames.size(); i++) {
					names[i]=MydAndNames.get(i).getName();
			}
		
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		
		return names;
	}

	@RequestMapping("toRqActivity")
	public String toRqActivity(Model model , HttpSession session) {
		Employee es = (Employee)session.getAttribute("user");
		List<Plate> plate = plateservice.queryLeftNav(es.getId());
		model.addAttribute("plist", plate);
		System.out.println("正在加载活动人气相关....");
		List<ActivityTwo>activityTwos = asi.selectByNameAndCount();
		for (ActivityTwo activityTwo : activityTwos) {
			System.out.println("抽取数据："+activityTwo.getName()+"\t"+activityTwo.getValue());
			
		}
		model.addAttribute("ActivityTj", activityTwos);
		return "echarts4";
	}
	
	@RequestMapping("toAjaxActivity")
	@ResponseBody
	public List<ActivityTwo> toAjaxActivity() {
		List<ActivityTwo>activityTwos = asi.selectByNameAndCount();
		return activityTwos;
	}
	
	@RequestMapping("toAjaxActivityTwo")
	@ResponseBody
	public String[] toAjaxActivityTwo() {
		List<ActivityTwo>activityTwos = asi.selectByNameAndCount();
		String[] names = new String[activityTwos.size()];
			for (int i = 0; i < activityTwos.size(); i++) {
					names[i]=activityTwos.get(i).getName();
			}
		
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		
		return names;
	}

	/**
	 * 每月订单数量统计
	 * @return
	 */
	@RequestMapping("toMothKh")
	public String toMothKh(Model model , HttpSession session) {
		Employee es = (Employee)session.getAttribute("user");
		List<Plate> plate = plateservice.queryLeftNav(es.getId());
		model.addAttribute("plist", plate);
		System.out.println("正在加载每月订单数...");
		System.out.println("查询到以下数据:");
		List<MonthOrder>monthOrders = osi.SelectMonthOr("2019");
		
		List<MonthOrder>monthOrders2 = osi.SelectOrYears();
		model.addAttribute("years", monthOrders2);
		
		model.addAttribute("monthOrders", monthOrders);
		
		return "echarts5";
	}
	
	@RequestMapping("toAjaxMonthOr")
	@ResponseBody
	public int[] toAjaxMonthOr(String years) {
		System.out.println("接收到年份:"+years);
		List<MonthOrder>monthOrders = osi.SelectMonthOr(years);
		int[] sum = {0,0,0,0,0,0,0,0,0,0,0,0};
		for (MonthOrder monthOrder : monthOrders) {
			Integer month = Integer.valueOf(monthOrder.getMonths());
			System.out.println("月份:"+month);
			System.out.println("数量"+monthOrder.getSum());
			sum[month-1]=monthOrder.getSum();
		}
		return sum;
	}
	
	@RequestMapping("toAjaxMonthOrtwo")
	@ResponseBody
	public List<MonthOrder> toAjaxMonthOrtwo(String years) {
		List<MonthOrder>monthOrders = osi.SelectMonthOr(years);
		return monthOrders;
	}

	@RequestMapping("toYgKq")
	public String toYgKq(Model model, HttpSession session) {
		Employee es = (Employee)session.getAttribute("user");
		List<Plate> plate = plateservice.queryLeftNav(es.getId());
		model.addAttribute("plist", plate);
		List<MydAndName>mydAndNames = usi.selectByCp();
		model.addAttribute("mydAndNames", mydAndNames);
		return "echarts6";
	}
	
	@RequestMapping("toYgKqAjax")
	@ResponseBody
	public List<MydAndName> toYgKqAjax() {
		List<MydAndName>mydAndNames = usi.selectByCp();
		return mydAndNames;
	}
	
	@RequestMapping("toYgKqAjax2")
	@ResponseBody
	public String[] toYgKqAjax2() {
		List<MydAndName>MydAndNames = usi.selectByCp();
		String [] names = new String[MydAndNames.size()];
			for (int i = 0; i < MydAndNames.size(); i++) {
					names[i]=MydAndNames.get(i).getName();
			}
		
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		
		return names;
	}

	@RequestMapping("toQuestion")
	public String toQuestion(Model model, HttpSession session) {
		Employee es = (Employee)session.getAttribute("user");
		List<Plate> plate = plateservice.queryLeftNav(es.getId());
		model.addAttribute("plist", plate);
		System.out.println("正在加载满意度调查统计...");
		System.out.println("正在查询项目数据...");
		List<Project>projects = psi.queryAllProject();
		for (Project project : projects) {
			System.out.println("项目名称:"+project.getProjectname());
		}
		List<QuestionTj>questionTjs = psi.selectByQuestion("骑马");
		for (QuestionTj questionTj : questionTjs) {
			System.out.println("测试数据，试试看："+questionTj.getProjectname());
			System.out.println(questionTj.getNumcount());
			System.out.println(questionTj.getSatisfied());
		}
		model.addAttribute("projects", projects);
		return "echarts7";
	}
	
	@RequestMapping("toAjaxQuestion")
	@ResponseBody
	public List<QuestionTwo> toAjaxQuestion(String projectName) {
		List<QuestionTwo>questionTwos = new ArrayList<>();
		
		List<QuestionTj>questionTjs = psi.selectByQuestion(projectName);
		
		Map<String, String>nameMap = new HashMap<>();
		
		for (QuestionTj questionTj : questionTjs) {
			if(nameMap.containsKey(questionTj.getProjectname())) {
				continue;
			}
			nameMap.put(questionTj.getProjectname(), "已有");
			
			QuestionTwo questionTwo = new QuestionTwo();
			
			questionTwo.setProjectname(questionTj.getProjectname());
			
			for (QuestionTj questionTj2 : questionTjs) {
				if(questionTj2.getProjectname().equals(questionTwo.getProjectname())) {
					int Myd = questionTj2.getSatisfied();
					int [] num= questionTwo.getNumcount();
					num[Myd-1] = questionTj2.getNumcount();
					questionTwo.setNumcount(num);
				}
			}
			questionTwos.add(questionTwo);
		}
		return questionTwos;
	}
	

}
