package com.accp.domain;

import java.util.List;

public class Activity {
    private Integer id;

    private String aName;

    private String aZbf;

    private String aPrice;

    private String aJieshao;

    private String aAge;

    private String aHaochu;

    private Integer count;

    private String spare1;

    private String spare2;

    private String spare3;

    private String spare4;

    private String spare5;
    

    private List<Eventitems> evelist; 

	private List<Eventitems> elist;

	

	public List<Eventitems> getEvelist() {
		return evelist;
	}

	public void setEvelist(List<Eventitems> evelist) {
		this.evelist = evelist;
	}



    public List<Eventitems> getElist() {
		return elist;
	}

	public void setElist(List<Eventitems> elist) {
		this.elist = elist;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaZbf() {
        return aZbf;
    }

    public void setaZbf(String aZbf) {
        this.aZbf = aZbf;
    }

    public String getaPrice() {
        return aPrice;
    }

    public void setaPrice(String aPrice) {
        this.aPrice = aPrice;
    }

    public String getaJieshao() {
        return aJieshao;
    }

    public void setaJieshao(String aJieshao) {
        this.aJieshao = aJieshao;
    }

    public String getaAge() {
        return aAge;
    }

    public void setaAge(String aAge) {
        this.aAge = aAge;
    }

    public String getaHaochu() {
        return aHaochu;
    }

    public void setaHaochu(String aHaochu) {
        this.aHaochu = aHaochu;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getSpare1() {
        return spare1;
    }

    public void setSpare1(String spare1) {
        this.spare1 = spare1;
    }

    public String getSpare2() {
        return spare2;
    }

    public void setSpare2(String spare2) {
        this.spare2 = spare2;
    }

    public String getSpare3() {
        return spare3;
    }

    public void setSpare3(String spare3) {
        this.spare3 = spare3;
    }

    public String getSpare4() {
        return spare4;
    }

    public void setSpare4(String spare4) {
        this.spare4 = spare4;
    }

    public String getSpare5() {
        return spare5;
    }

    public void setSpare5(String spare5) {
        this.spare5 = spare5;
    }
}