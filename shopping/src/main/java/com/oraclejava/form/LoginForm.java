package com.oraclejava.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {

	@NotNull(message = "로그인 아이디는 필수 입력입니다.")
	@Size(min = 1, message = "로그인 아이디는 필수 입력입니다.")
	private String login;
	
	@NotNull(message = "패스워드는 필수 입력입니다.")
	@Size(min = 1, message = "패스워드는 필수 입력입니다.")
	private String password;
	
	// get, set
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
