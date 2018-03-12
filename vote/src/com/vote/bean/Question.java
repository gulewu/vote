package com.vote.bean;

public class Question {
	private int oid;
	private int seq;
	private int qtype;
	private String content;
	private String remark;

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getOid() {
		return this.oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getQtype() {
		return this.qtype;
	}

	public void setQtype(int qtype) {
		this.qtype = qtype;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getSeq() {
		return this.seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}
}
