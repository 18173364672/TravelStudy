package com.accp.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Orderdetail {
    private Integer id;

    private Integer oid;

    private Integer fid;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date starttime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endtime;

    private Integer pid;

    private Double dj;

    private String spare1;

    private String spare2;

    private String spare3;

    private String spare4;

    private String spare5;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date starttime1;
    
    public Date getStarttime1() {
		return starttime1;
	}

	public void setStarttime1(Date starttime1) {
		this.starttime1 = starttime1;
	}

	public Date getEndtime1() {
		return endtime1;
	}

	public void setEndtime1(Date endtime1) {
		this.endtime1 = endtime1;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endtime1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Double getDj() {
        return dj;
    }

    public void setDj(Double dj) {
        this.dj = dj;
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