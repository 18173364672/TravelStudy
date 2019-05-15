package com.accp.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Userprojectdiscuss {
    private Integer id;

    private Integer userid;

    private Integer projectid;

    private String userdiscuss;

    private Integer satisfied;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date discusstime;

    private String spare1;

    private String spare2;

    private String spare3;

    private String spare4;

    private String spare5;
    
    private List<Userprojectimg> userproimglist;
    
    private Customerss customersso;
    
    private String uname;

    public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Customerss getCustomersso() {
		return customersso;
	}

	public void setCustomersso(Customerss customersso) {
		this.customersso = customersso;
	}

	public List<Userprojectimg> getUserproimglist() {
		return userproimglist;
	}

	public void setUserproimglist(List<Userprojectimg> userproimglist) {
		this.userproimglist = userproimglist;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public String getUserdiscuss() {
        return userdiscuss;
    }

    public void setUserdiscuss(String userdiscuss) {
        this.userdiscuss = userdiscuss;
    }

    public Integer getSatisfied() {
        return satisfied;
    }

    public void setSatisfied(Integer satisfied) {
        this.satisfied = satisfied;
    }

    public Date getDiscusstime() {
        return discusstime;
    }

    public void setDiscusstime(Date discusstime) {
        this.discusstime = discusstime;
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