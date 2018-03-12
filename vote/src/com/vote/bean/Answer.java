package com.vote.bean;

public class Answer {
	private int answerId;
	private int replayId;
	private int oid;
	private int qSeq;
	private int seSeq;
	private String seValue;
	private String remark;

	public int getAnswerId() {
		return this.answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public int getReplayId() {
		return this.replayId;
	}

	public void setReplayId(int replayId) {
		this.replayId = replayId;
	}

	public int getOid() {
		return this.oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getqSeq() {
		return this.qSeq;
	}

	public void setqSeq(int qSeq) {
		this.qSeq = qSeq;
	}

	public int getSeSeq() {
		return this.seSeq;
	}

	public void setSeSeq(int seSeq) {
		this.seSeq = seSeq;
	}

	public String getSeValue() {
		return this.seValue;
	}

	public void setSeValue(String seValue) {
		this.seValue = seValue;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
