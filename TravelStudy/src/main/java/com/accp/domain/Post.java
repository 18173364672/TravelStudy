package com.accp.domain;

import java.util.Date;
import java.util.List;

import org.apache.catalina.User;

public class Post {
    private Integer id;

    private Integer uid;

    private String title;

    private Date dytime;

    private String dycontent;

    private Integer pointsum;

    private Integer tid;

    private Integer yxx;

    private String spare1;

    private String spare2;

    private String spare3;

    private String spare4;

    private String spare5;
    
    private List<Dynamicpicture> dylist;
    
    private List<Comment> coList;
    
    private Customerss Customerss;
    
    
 
    public List<Comment> getCoList() {
		return coList;
	}

	public void setCoList(List<Comment> coList) {
		this.coList = coList;
	}

	public Customerss getCustomerss() {
		return Customerss;
	}

	public void setCustomerss(Customerss customerss) {
		Customerss = customerss;
	}

	public List<Dynamicpicture> getDylist() {
		return dylist;
	}

	public void setDylist(List<Dynamicpicture> dylist) {
		this.dylist = dylist;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDytime() {
        return dytime;
    }

    public void setDytime(Date dytime) {
        this.dytime = dytime;
    }

    public String getDycontent() {
        return dycontent;
    }

    public void setDycontent(String dycontent) {
        this.dycontent = dycontent;
    }

    public Integer getPointsum() {
        return pointsum;
    }

    public void setPointsum(Integer pointsum) {
        this.pointsum = pointsum;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getYxx() {
        return yxx;
    }

    public void setYxx(Integer yxx) {
        this.yxx = yxx;
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

	public Post( Integer uid, String title, Date dytime, String dycontent, Integer pointsum, Integer tid) {
		super();
	
		this.uid = uid;
		this.title = title;
		this.dytime = dytime;
		this.dycontent = dycontent;
		this.pointsum = pointsum;
		this.tid = tid;


	}
	
	public Post() {
		// TODO Auto-generated constructor stub
	}
    
    
    
    
}