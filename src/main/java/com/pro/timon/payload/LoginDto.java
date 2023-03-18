package com.pro.timon.payload;

public class LoginDto {

	private String mail;
	private String password;
	
	public LoginDto(String mail, String password) {
		super();
		this.mail = mail;
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
