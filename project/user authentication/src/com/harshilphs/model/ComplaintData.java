package com.harshilphs.model;

import java.sql.Timestamp;

public class ComplaintData {
	private int id;
	private int userId;
	private String sub;
	private String desc;
	private String address;
	private String status;
	private Timestamp datetime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getDatetime() {
		return datetime;
	}
	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "ComplaintData [id=" + id + ", userId=" + userId + ", sub=" + sub + ", desc=" + desc + ", address="
				+ address + ", status=" + status + ", datetime=" + datetime + "]";
	}
	
	
}
