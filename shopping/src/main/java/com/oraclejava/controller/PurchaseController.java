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
		
		//카트를 가져오자!
		List<Item> cart = (List<Item>)session.getAttribute("cart");
		
		// 카트를 방치(30분이상)
		if (cart == null) {
			model.addAttribute("contents", "purchase-out :: error-cart");
			return "index";
		}
		
		purchaseRepository.insert(cart, name, address);
		
		model.addAttribute("contents", "purchase-out :: purchase-out");
		return "index";
	}

	
}





