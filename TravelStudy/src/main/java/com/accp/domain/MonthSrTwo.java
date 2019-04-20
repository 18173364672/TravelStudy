package com.accp.domain;

/**
 * 每月收入副数据
 * @author Nostalgic
 *
 */
public class MonthSrTwo {
	
	private int id;
	
	private int[] sumPrice = {0,0,0,0,0,0,0,0,0,0,0,0};

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int[] getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(int[] sumPrice) {
		this.sumPrice = sumPrice;
	}


	
	
}
