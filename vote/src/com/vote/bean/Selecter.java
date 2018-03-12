package com.vote.bean;

public class Selecter {
	private int qseq;
	private int oid;
	private int selseq;
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

	public int getQseq() {
		return this.qseq;
	}

	public void setQseq(int qseq) {
		this.qseq = qseq;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getSelseq() {
		return this.selseq;
	}

	public void setSelseq(int selseq) {
		this.selseq = selseq;
	}
}
