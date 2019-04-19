package com.accp.domain;

import java.util.HashMap;

/**
 * 项目人气统计实体类
 * @author Nostalgic
 *
 */
public class ProjectByTimeAndName {
	private String Projectname;
	private int RenQi;
	private int countPrice;
	private String months;
	private String years;
	
	
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public String getProjectname() {
		return Projectname;
	}
	public void setProjectname(String projectname) {
		Projectname = projectname;
	}
	public int getRenQi() {
		return RenQi;
	}
	public void setRenQi(int renQi) {
		RenQi = renQi;
	}
	public int getCountPrice() {
		return countPrice;
	}
	public void setCountPrice(int countPrice) {
		this.countPrice = countPrice;
	}
	public String getMonths() {
		return months;
	}
	public void setMonths(String months) {
		this.months = months;
	}
	
	
}
