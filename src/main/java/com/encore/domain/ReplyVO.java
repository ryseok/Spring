package com.encore.domain;

import java.util.Date;
//날짜	 : 180905
//작성자	 : rys
//제목	 : 댓글
//파일명	 : ReplyVO.java
public class ReplyVO {

	private int rno; 			//댓글번호(자동추가)
	private int bno; 			//게시물번호
	private String replytext; 	//댓글내용
	private String replyer; 	//댓글 작성자
	private Date regdate; 		//댓글 등록일
	private Date updatedate; 	//댓글 수정일
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	@Override
	public String toString() {
		return "ReplyVO [rno=" + rno + ", bno=" + bno + ", replytext=" + replytext + ", replyer=" + replyer
				+ ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
	}

	

}
