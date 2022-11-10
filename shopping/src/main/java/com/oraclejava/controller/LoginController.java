package com.oraclejava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.oraclejava.form.LoginForm;

@Controller
public class LoginController {

	@ModelAttribute
	public LoginForm setLoginForm() {
		return new LoginForm();
	}
	
	//로그인 화면
	@GetMapping("/login")
	public String loginForm() {
		return "login-in";
	}
	
	//로그인 처리
	@PostMapping("/login")
	public String loginAction(@Validated LoginForm loginForm,
			BindingResult result, Model model) {
		System.out.println("login");
		if (result.hasErrors()) {
			return loginForm();  //2
		}
		
		return "login-out"; // 1.로그인에 성공하셨습니다!
	}
}





