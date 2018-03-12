package com.vote.bean;

import java.sql.Timestamp;

public class ObjectBean {
	private int oid;
	private String title;
	private String discribe;
	private Timestamp createTime;
	private String remark;
	private int state;
	private String anonymousFlag;

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getOid() {
		return this.oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDiscribe(String discribe) {
		this.discribe = discribe;
	}

	public String getTitle() {
		return this.title;
	}

	public String getDiscribe() {
		return this.discribe;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAnonymousFlag() {
		return this.anonymousFlag;
	}

	public void setAnonymousFlag(String anonymousFlag) {
		this.anonymousFlag = anonymousFlag;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
}
