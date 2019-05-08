package com.accp.pda.vo;

import java.util.List;

import com.accp.domain.Activity;
import com.accp.domain.Project;

public class ActivtyVo {

	public Activity getAct() {
		return act;
	}

	public void setAct(Activity act) {
		this.act = act;
	}

	public List<Project> getList() {
		return list;
	}

	public void setList(List<Project> list) {
		this.list = list;
	}

	//活动对象
	private Activity act;
	
	//项目集合
	private List<Project> list;
	
}
