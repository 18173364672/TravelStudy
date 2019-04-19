package com.accp.domain;

/**
 * 满意度(前端调查问卷)最终数据类
 * @author Nostalgic
 *
 */
public class QuestionTwo {
	
	private String projectname;
	
	private int[] numcount = {0,0,0};

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public int[] getNumcount() {
		return numcount;
	}

	public void setNumcount(int[] numcount) {
		this.numcount = numcount;
	}
	
	
}
