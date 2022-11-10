package com.oraclejava.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oraclejava.domain.Item;
import com.oraclejava.repository.PurchaseRepository;

@Controller
public class PurchaseController {

	private PurchaseRepository purchaseRepository;

	public PurchaseController(PurchaseRepository purchaseRepository) {
		super();
		this.purchaseRepository = purchaseRepository;
	}
	
	@RequestMapping("/purchase")
	public String pur(@RequestParam("name") String name,
					  @RequestParam("address") String address,
					  HttpSession session,
					  Model model) {
		//이름이나 주소를 입력하지 않을 경우 유효성 검사
		if (name.isEmpty() || address.isEmpty()) {
			model.addAttribute("contents", "purchase-out :: error-empty");
			return "index";
		}
		
		
		//카트를 가져오자!
		List<Item> cart = (List<Item>)session.getAttribute("cart");
		
		// 카트를 방치(30분이상)한 경우 에러 메시지 표시
		if (cart == null) {
			model.addAttribute("contents", "purchase-out :: error-cart");
			return "index";
		}
		
		purchaseRepository.insert(cart, name, address);
		
		// 구입이 완료된 경우 카트를 반납
		session.removeAttribute("cart");
		
		model.addAttribute("contents", "purchase-out :: purchase-out");
		return "index";
	}

	
}





