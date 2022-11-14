package com.oraclejava.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.oraclejava.domain.Customer;
import com.oraclejava.form.LoginForm;
import com.oraclejava.repository.CustomerRepository;

@Controller
public class LoginController {

	private CustomerRepository customerRepository;
	
	public LoginController(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@ModelAttribute
	public LoginForm setLoginForm() {
		return new LoginForm();
	}
	
	//로그인 화면
	@GetMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("contents", "login-in :: login");
		return "index";
	}
	
	//로그인 처리
	@PostMapping("/login")
	public String loginAction(@Validated LoginForm loginForm,
			BindingResult result, Model model, HttpSession session) {
		System.out.println("login");
		if (result.hasErrors()) {
			return loginForm(model);  //2
		}
		
		Customer customer = customerRepository.search(
				loginForm.getLogin(), loginForm.getPassword());
		
		if (customer != null) {
			session.setAttribute("customer", customer);
			model.addAttribute("contents", "login-out :: login");
			return "index"; // 1.로그인에 성공하셨습니다!
		} else {
			// 로그인 실패
			model.addAttribute("contents", "error-login :: login");
			return "index"; //2. 아이디나 패스워드를 확인하세요
		}
		
		
	}
}





