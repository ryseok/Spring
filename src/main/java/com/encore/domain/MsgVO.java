package com.encore.domain;

import java.util.Date;

public class MsgVO {
	private int mno;
	private String senderid;
	private String receiverid;
	private String msg;
	private Date senddate;
	private Date opendate;

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getSenderid() {
		return senderid;
	}

	public void setSenderid(String senderid) {
		this.senderid = senderid;
	}

	public String getReceiverid() {
		return receiverid;
	}

	public void setReceiverid(String receiverid) {
		this.receiverid = receiverid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getSenddate() {
		return senddate;
	}

	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}

	public Date getOpendate() {
		return opendate;
	}

	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}

	@Override
	public String toString() {
		return "MsgVO [mno=" + mno + ", senderid=" + senderid + ", receiverid=" + receiverid + ", msg=" + msg
				+ ", senddate=" + senddate + ", opendate=" + opendate + "]";
	}

}
