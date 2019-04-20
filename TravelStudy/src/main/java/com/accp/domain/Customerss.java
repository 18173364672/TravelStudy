package com.accp.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Customerss {
    private Integer id;

    private String username;

    private String userpassword;

    private String email;

    private String sex;

    private String phone;

    private String address;
   
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createtime;

    private Double consumption;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date finaltime;

    private Integer consume;

    private String idcard;

    private String uimg;

    private Integer state;

    private Integer groupid;

    private String spare1;

    private String spare2;

    private String spare3;

    private String spare4;

    private String spare5;
    
    private String groupname;

    public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Double getConsumption() {
        return consumption;
    }

    public void setConsumption(Double consumption) {
        this.consumption = consumption;
    }

    public Date getFinaltime() {
        return finaltime;
    }

    public void setFinaltime(Date finaltime) {
        this.finaltime = finaltime;
    }

    public Integer getConsume() {
        return consume;
    }

    public void setConsume(Integer consume) {
        this.consume = consume;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getUimg() {
        return uimg;
    }

    public void setUimg(String uimg) {
        this.uimg = uimg;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
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