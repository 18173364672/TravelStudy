package com.accp.zjq.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.cxf.binding.soap.Soap11;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

	/**
	 * 跳转到项目人气
	 * @param model 所有项目的数据以及年份数据
	 * @return
	 */
	@RequestMapping("/toRqProject")
	public String toRqProject(Model model, HttpSession session) {
		Employee es = (Employee)session.getAttribute("user");
		List<Plate> plate = plateservice.queryLeftNav(es.getId());
		model.addAttribute("plist", plate);
		System.out.println("加载项目人气页面中...");
		List<MonthOrder>monthOrders2 = osi.SelectOrYears();
		
		List<Project>projects = psi.queryAllProject();
		model.addAttribute("project", projects);
		model.addAttribute("years", monthOrders2);
		return "echarts1";
	}
	
	/**
	 * 通过时间和名称查出项目人气项目
	 * @param years年份
	 * @param name 项目名
	 * @return
	 */
	@RequestMapping("toAjaxProject")
	@ResponseBody
	public List<ProjectByTimeAndName> toAjaxProject(String years,String name) {
		List<ProjectByTimeAndName>projectByTimeAndNames = psi.selectXmTable(years,name);
		return projectByTimeAndNames;
	}
	
	/**
	 * 某年每月项目及使用次数数据导入Excel表格
	 * @param projectname项目名称
	 * @param years年份
	 * @return
	 */
	@RequestMapping("/daoru")
	public ResponseEntity<byte[]> export(String projectname,String years) {
		System.out.println(projectname);
		List<ProjectByTimeAndName> list = psi.selectXmTable(years,projectname);
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("your sheet");
		Row row0= sheet.createRow(0);
		Cell cell = row0.createCell(0);
		cell.setCellValue("月份");
		Cell cell1 = row0.createCell(1);
		cell1.setCellValue("人气");
		for (int i = 0; i < list.size(); i++) {
			Row row = sheet.createRow(i+1);
			Cell id = row.createCell(0);
			id.setCellValue(list.get(i).getMonths());
			Cell name = row.createCell(1);
			name.setCellValue(list.get(i).getRenQi());
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			workbook.write(bos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		try {
			String filename = years+"年"+projectname+"报表.xlsx";
			headers.setContentDispositionFormData("attachment", new String(filename.getBytes("utf-8"), "iso-8859-1"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(bos.toByteArray(),headers,HttpStatus.OK);
	}

	/**
	 * 查询项目人气数据渲染统计图
	 * @param years年份
	 * @return
	 */
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

	
	/**
	 * 跳转每月收入页面
	 * @param model每月收入数据
	 * @return
	 */
	@RequestMapping("toMonthSr")
	public String toMonthSr(Model model , HttpSession session) {
		Employee es = (Employee)session.getAttribute("user");
		List<Plate> plate = plateservice.queryLeftNav(es.getId());
		model.addAttribute("plist", plate);
		List<MonthOrder>monthOrders2 = osi.SelectOrYears();
		model.addAttribute("years", monthOrders2);
		return "echarts2";
	}
	
	/**
	 * 数据渲染每页收入统计图
	 * @param years年份
	 * @return
	 */
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
	
	@RequestMapping("toAjaxQueryMonthSrTwo")
	@ResponseBody
	public List<MonthSr> toAjaxQueryMonthSrTwo(String years) {
		List<MonthSr>monthSrs = osi.selectMonthSr(years);
		return monthSrs;
	}
	
	/**
	 * 导入某年份每月收入Excel报表
	 * @param years数据年份信息
	 * @return
	 */
	@RequestMapping("/MonthsSrExcel")
	public ResponseEntity<byte[]> MonthsSrExcel(String years) {
		//输出语句，判断是否进入此方法
		System.out.println("正准备导入Excel，获取到年份："+years+"\n准备开始导入");
		
		//后台查询数据需要导入Excel的数据
		List<MonthSr>monthSrs = osi.selectMonthSr(years);
		
		//创建一个XSSFworkbook对象，此对象可用于Excel的读写
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		//XSSFWorkbook对象创建一个Sheet对象（Sheet页对象），也就是相当于用Excel创建了页面下面的Sheet页
		Sheet sheet = workbook.createSheet("your sheet");
		
		//创建Excel一行，createRow(0)也就是创建了Excel中的第一行
		Row row0= sheet.createRow(0);
		
		//创建Excel中第一行第一格的单元格对象
		Cell cell = row0.createCell(0);
		cell.setCellValue("月份"); //上面创建的单元格对象赋值
		
		//创建Excel中第一行第二格的单元对象
		Cell cell1 = row0.createCell(1);
		cell1.setCellValue("收入"); //上面创建单元格对象赋值
		
		//创建Excel中第一行第三个的单元对象
		Cell cell2 = row0.createCell(2);
		cell2.setCellValue("总计:");//上面创建单元格对象赋值
		
		//定义double类型，总计收入
		double sum = 0;
		//for循环，循环数据库拿到的每月收入数据，并且循环创建Excel下面的行和列（单元格）
		for (int i = 0; i < monthSrs.size(); i++) {
			//创建新的一行
			Row row = sheet.createRow(i+1);
			//在新建的一行中创建第一格单元格
			Cell months = row.createCell(0);
			months.setCellValue(monthSrs.get(i).getMonths());//将循环拿到的数据赋值进新建的单元格，也就是上面的months对象中
			//在新建的一行汇总创建第二格单元格
			Cell income = row.createCell(1);
			income.setCellValue(monthSrs.get(i).getSumprice());//将循环拿到的数据赋值进新建的单元格，也就是上面的income对象中
			//将循环的每月收入进行相加得到总计
			sum+=monthSrs.get(i).getSumprice();
		}
		//创建第一行第四个单元格，用于存放总计数据
		Cell cell3 = row0.createCell(3);
		cell3.setCellValue(sum);//将计算后的sum赋值给单元格
		
		/**
		 * 下面就是写控制器的代码
		 * 
		 * 
		 * 创建一个32字节（默认大小）的缓冲区，字节数组输出流在内存中创建一个字节数组缓冲区，所有发送到输出流的数据保存在该字节数组缓冲区中
		 * 转化为字节流
		 */
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		try {
			//生成字节流
			workbook.write(bos);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//创建HttpHeaders类对象，下面设置HttpHeaders使得浏览器能响应下载
		HttpHeaders headers = new HttpHeaders();
		
		try {
			//一个Excel肯定要有名字啦，我这里先用一个字符串接收
			String filename = years+"年每月收入报表.xlsx";
			
			//设置响应（页面导入的Excel）文件，文件传输时会有乱码，这里可以解决这个问题，filename就是上面我们的Excel文件名
			headers.setContentDispositionFormData("attachment", new String(filename.getBytes("utf-8"), "iso-8859-1"));
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//设置响应方式
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		
		//以二进制形式进行return返回
		return new ResponseEntity<byte[]>(bos.toByteArray(),headers,HttpStatus.OK);
	}
	
	
	/**
	 * 跳转项目满意数对比页面
	 * @param model
	 * @return
	 */
	@RequestMapping("toRqTeacher")
	public String toRqTeacher(Model model , HttpSession session) {
		Employee es = (Employee)session.getAttribute("user");
		List<Plate> plate = plateservice.queryLeftNav(es.getId());
		model.addAttribute("plist", plate);
		
		List<MydAndName>mydAndNames = usi.selectByMyd();
		
		model.addAttribute("mydAndNames", mydAndNames);
		
		return "echarts3";
	}
	
	/**
	 * 数据渲染满意度数据表格
	 * @return
	 */
	@RequestMapping("toAjaxMyd")
	@ResponseBody
	public List<MydAndName> toAjaxMyd(){
		List<MydAndName>mydAndNames = usi.selectByMyd();
		return mydAndNames;
	}
	
	/**
	 * 数据渲染满意度对比统计图
	 * @return
	 */
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
	
	/**
	 * 导入项目满意数对比Excel报表
	 * @return
	 */
	@RequestMapping("/MontMydDBExcelhsSrExcel")
	public ResponseEntity<byte[]> MydDBExcel() {
		System.out.println("准备开始导入");
		List<MydAndName>mydAndNames = usi.selectByMyd();
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("your sheet");
		Row row0= sheet.createRow(0);
		Cell cell = row0.createCell(0);
		cell.setCellValue("项目名");
		Cell cell1 = row0.createCell(1);
		cell1.setCellValue("满意数");
		Cell cell2 = row0.createCell(2);
		for (int i = 0; i < mydAndNames.size(); i++) {
			Row row = sheet.createRow(i+1);
			Cell id = row.createCell(0);
			id.setCellValue(mydAndNames.get(i).getName());
			Cell name = row.createCell(1);
			name.setCellValue(mydAndNames.get(i).getValue());
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			workbook.write(bos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		try {
			String filename = "截止至今项目满意数对比数据报表.xlsx";
			headers.setContentDispositionFormData("attachment", new String(filename.getBytes("utf-8"), "iso-8859-1"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(bos.toByteArray(),headers,HttpStatus.OK);
	}

	
	
	/**
	 * 跳转人气活动页面
	 * @param model
	 * @return
	 */
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
	
	/**
	 * 数据渲染人气活动数据表格
	 * @return
	 */
	@RequestMapping("toAjaxActivity")
	@ResponseBody
	public List<ActivityTwo> toAjaxActivity() {
		List<ActivityTwo>activityTwos = asi.selectByNameAndCount();
		return activityTwos;
	}
	
	
	/**
	 * 数据渲染人气活动数据统计图
	 * @return
	 */
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
	 * 导入最受欢迎数据Excel报表
	 * @return
	 */
	@RequestMapping("/MonthsDdnum")
	public ResponseEntity<byte[]> MonthsDdnum() {
		System.out.println("准备开始导入");
		List<ActivityTwo>activityTwos = asi.selectByNameAndCount();
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("your sheet");
		Row row0= sheet.createRow(0);
		Cell cell = row0.createCell(0);
		cell.setCellValue("活动名");
		Cell cell1 = row0.createCell(1);
		cell1.setCellValue("使用次数");
		Cell cell2 = row0.createCell(2);
		for (int i = 0; i < activityTwos.size(); i++) {
			Row row = sheet.createRow(i+1);
			Cell id = row.createCell(0);
			id.setCellValue(activityTwos.get(i).getName());
			Cell name = row.createCell(1);
			name.setCellValue(activityTwos.get(i).getValue());
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			workbook.write(bos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		try {
			String filename = "截止至今最受欢迎数据报表.xlsx";
			headers.setContentDispositionFormData("attachment", new String(filename.getBytes("utf-8"), "iso-8859-1"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(bos.toByteArray(),headers,HttpStatus.OK);
	}
	
	

	/**
	 * 跳转每月订单量页面
	 * @return
	 */
	@RequestMapping("toMothKh")
	public String toMothKh(Model model , HttpSession session) {
		Employee es = (Employee)session.getAttribute("user");
		List<Plate> plate = plateservice.queryLeftNav(es.getId());
		model.addAttribute("plist", plate);
		System.out.println("正在加载每月订单数...");
		System.out.println("查询到以下数据:");
		 Calendar date = Calendar.getInstance();
	     String year = String.valueOf(date.get(Calendar.YEAR));
		List<MonthOrder>monthOrders = osi.SelectMonthOr(year);
		
		List<MonthOrder>monthOrders2 = osi.SelectOrYears();
		model.addAttribute("years", monthOrders2);
		
		model.addAttribute("monthOrders", monthOrders);
		
		return "echarts5";
	}
	
	/**
	 * 导入某年份每月订单量Excel报表
	 * @param years年份
	 * @return
	 */
	@RequestMapping("/MonthsDdExcel")
	public ResponseEntity<byte[]> MonthsDdExcel(String years) {
		System.out.println("正准备导入Excel，获取到年份："+years+"\n准备开始导入");
		List<MonthOrder>monthOrders = osi.SelectMonthOr(years);
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("your sheet");
		Row row0= sheet.createRow(0);
		Cell cell = row0.createCell(0);
		cell.setCellValue("月份");
		Cell cell1 = row0.createCell(1);
		cell1.setCellValue("订单量");
		Cell cell2 = row0.createCell(2);
		cell2.setCellValue("总计:");
		double sum = 0;
		for (int i = 0; i < monthOrders.size(); i++) {
			Row row = sheet.createRow(i+1);
			Cell id = row.createCell(0);
			id.setCellValue(monthOrders.get(i).getMonths());
			Cell name = row.createCell(1);
			name.setCellValue(monthOrders.get(i).getSum());
			sum+=monthOrders.get(i).getSum();
		}
		Cell cell3 = row0.createCell(3);
		cell3.setCellValue(sum);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			workbook.write(bos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		try {
			String filename = years+"年每月订单量报表.xlsx";
			headers.setContentDispositionFormData("attachment", new String(filename.getBytes("utf-8"), "iso-8859-1"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(bos.toByteArray(),headers,HttpStatus.OK);
	}
	
	/**
	 * 数据渲染每月订单量统计图
	 * @param years
	 * @return
	 */
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
	
	/**
	 * 渲染每月订单量数据表格
	 * @param years
	 * @return
	 */
	@RequestMapping("toAjaxMonthOrtwo")
	@ResponseBody
	public List<MonthOrder> toAjaxMonthOrtwo(String years) {
		List<MonthOrder>monthOrders = osi.SelectMonthOr(years);
		return monthOrders;
	}

	
	/**
	 * 跳转项目差评对比页面
	 * @param model
	 * @return
	 */
	@RequestMapping("toYgKq")
	public String toYgKq(Model model, HttpSession session) {
		Employee es = (Employee)session.getAttribute("user");
		List<Plate> plate = plateservice.queryLeftNav(es.getId());
		model.addAttribute("plist", plate);
		List<MydAndName>mydAndNames = usi.selectByCp();
		model.addAttribute("mydAndNames", mydAndNames);
		return "echarts6";
	}
	
	/**
	 * 导入项目差评对比Excel报表
	 * @return
	 */
	@RequestMapping("/CpDBExcel")
	public ResponseEntity<byte[]> CpDBExcel() {
		System.out.println("准备开始导入");
		List<MydAndName>mydAndNames = usi.selectByCp();
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("your sheet");
		Row row0= sheet.createRow(0);
		Cell cell = row0.createCell(0);
		cell.setCellValue("项目名");
		Cell cell1 = row0.createCell(1);
		cell1.setCellValue("差评数");
		Cell cell2 = row0.createCell(2);
		for (int i = 0; i < mydAndNames.size(); i++) {
			Row row = sheet.createRow(i+1);
			Cell id = row.createCell(0);
			id.setCellValue(mydAndNames.get(i).getName());
			Cell name = row.createCell(1);
			name.setCellValue(mydAndNames.get(i).getValue());
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			workbook.write(bos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		try {
			String filename = "截止至今项目差评数对比数据报表.xlsx";
			headers.setContentDispositionFormData("attachment", new String(filename.getBytes("utf-8"), "iso-8859-1"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(bos.toByteArray(),headers,HttpStatus.OK);
	}
	
	/**
	 * 数据渲染项目差评对比数据表格
	 * @return
	 */
	@RequestMapping("toYgKqAjax")
	@ResponseBody
	public List<MydAndName> toYgKqAjax() {
		List<MydAndName>mydAndNames = usi.selectByCp();
		return mydAndNames;
	}
	
	/**
	 * 数据渲染项目差评对比数据统计图
	 * @return
	 */
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

	/**
	 * 跳转问卷调查页面
	 * @param model
	 * @param projectName
	 * @return
	 */
	
	@RequestMapping("toQuestion")
	public String toQuestion(Model model,String projectName, HttpSession session) {
		Employee es = (Employee)session.getAttribute("user");
		List<Plate> plate = plateservice.queryLeftNav(es.getId());
		model.addAttribute("plist", plate);
		System.out.println("正在加载满意度调查统计...");
		System.out.println("正在查询项目数据...");
		List<Project>projects = psi.queryAllProject();
		for (Project project : projects) {
			System.out.println("项目名称:"+project.getProjectname());
		}

		model.addAttribute("projects", projects);
		return "echarts7";
	}
	

	/**
	 * 数据渲染问卷调查数据统计图
	 * @param projectName
	 * @return
	 */
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
	
	/**
	 * 数据渲染 问卷调差数据表格
	 * @param name
	 * @return
	 */
	@RequestMapping("toAjaxQuestionTwo")
	@ResponseBody
	public List<QuestionTj> toAjaxQuestionTwo(String name) {
		List<QuestionTj>questionTjs = psi.selectByQuestion(name);
		return questionTjs;
	}
	
	/**
	 * 导入某年份每月订单量Excel报表
	 * @param years年份
	 * @return
	 */
	@RequestMapping("/QuestionExcel")
	public ResponseEntity<byte[]> QuestionExcel(String projectname) {
		System.out.println("正准备导入Excel，获取到项目名称："+projectname+"\n准备开始导入");
		List<QuestionTj>questionTjs = psi.selectByQuestion(projectname);
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("your sheet");
		Row row0= sheet.createRow(0);
		Cell cell = row0.createCell(0);
		cell.setCellValue("反馈");
		Cell cell1 = row0.createCell(1);
		cell1.setCellValue("数量");
		for (int i = 0; i < questionTjs.size(); i++) {
			Row row = sheet.createRow(i+1);
			Cell id = row.createCell(0);
			Cell name = row.createCell(1);
			if(questionTjs.get(i).getSatisfied()==1) {
				id.setCellValue("满意");
				name.setCellValue(questionTjs.get(i).getNumcount());
			}if(questionTjs.get(i).getSatisfied()==2) {
				id.setCellValue("一般");
				name.setCellValue(questionTjs.get(i).getNumcount());
			}if(questionTjs.get(i).getSatisfied()==3) {
				id.setCellValue("很差");
				name.setCellValue(questionTjs.get(i).getNumcount());
			}
			
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			workbook.write(bos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		try {
			String filename = projectname+"问卷调差反馈报表.xlsx";
			headers.setContentDispositionFormData("attachment", new String(filename.getBytes("utf-8"), "iso-8859-1"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(bos.toByteArray(),headers,HttpStatus.OK);
	}
	

}
