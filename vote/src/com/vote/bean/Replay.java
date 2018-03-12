package com.vote.bean;

import java.sql.Timestamp;

public class Replay {
	private int replayId;
	private String replayCode;
	private String replayIp;
	private int oId;
	private Timestamp replayTime;
	private String remark;

	public int getReplayId() {
		return this.replayId;
	}

	public void setReplayId(int replayId) {
		this.replayId = replayId;
	}

	public String getReplayCode() {
		return this.replayCode;
	}

	public void setReplayCode(String replayCode) {
		this.replayCode = replayCode;
	}

	public String getReplayIp() {
		return this.replayIp;
	}

	public void setReplayIp(String replayIp) {
		this.replayIp = replayIp;
	}

	public int getoId() {
		return this.oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public Timestamp getReplayTime() {
		return this.replayTime;
	}

	public void setReplayTime(Timestamp replayTime) {
		this.replayTime = replayTime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
