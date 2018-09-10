package com.encore.dto;

public class LoginDTO { // UI통해 입력된(폼내의) 데이터들을 묶어주는 객체
	private String userid;
	private String userpw;
	private Boolean userCookie;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public Boolean getUserCookie() {
		return userCookie;
	}

	public void setUserCookie(Boolean userCookie) {
		this.userCookie = userCookie;
	}

	@Override
	public String toString() {
		return "LoginDTO [userid=" + userid + ", userpw=" + userpw + ", userCookie=" + userCookie + "]";
	}

}
