package com.txy.meet.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Management {
    private Integer id;

    private Integer mid;

    private String mname;

    @JSONField(format="yyyy/MM/dd")
    private Date startTime;

    @JSONField(format="yyyy/MM/dd")
    private Date endTime;

    private String mcity;

    private Integer mstates;

    private Integer proid;

    private Integer cityid;

    private String address;

    private String contacts;

    private String url;

    private String mphone;

    private String content;
    
    private String firstNum;
    
    private String SecondNum;
    
    public String getSecondNum() {
		return SecondNum;
	}

	public void setSecondNum(String secondNum) {
		SecondNum = secondNum;
	}

	public String getFirstNum() {
		return firstNum;
	}

	public void setFirstNum(String firstNum) {
		this.firstNum = firstNum;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getMcity() {
        return mcity;
    }

    public void setMcity(String mcity) {
        this.mcity = mcity == null ? null : mcity.trim();
    }

    public Integer getMstates() {
        return mstates;
    }

    public void setMstates(Integer mstates) {
        this.mstates = mstates;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone == null ? null : mphone.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}