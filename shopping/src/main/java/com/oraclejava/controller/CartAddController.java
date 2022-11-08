package com.oraclejava.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oraclejava.domain.Item;
import com.oraclejava.domain.Product;
import com.oraclejava.repository.ProductRepository;

@Controller
public class CartAddController {
	
	private ProductRepository productRepository;

	public CartAddController(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}



	@RequestMapping("/cartAdd")
	public String addCart(@RequestParam("id") Integer id, Model model,
			HttpSession session) {
		System.out.println("cartAdd");
		Product product = this.productRepository.findOne(id);
		model.addAttribute("id", id);
		model.addAttribute("name", product.getName());
		model.addAttribute("price", product.getPrice());
		model.addAttribute("contents", "cart :: cartView");
		
		// 카트 추가(룰루랄라!)
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		
		if (cart == null) {
			cart = new ArrayList<>();
			session.setAttribute("cart", cart);
		}
		
		// 기존 카트에 제품이 존재하면 갯수를 증가
		for (Item i : cart) {
			if (i.getProduct().getId() == id) {
				i.setCount(i.getCount() + 1);  // 갯수 증가
				return "index";
			}
		}
		
		
		// 카드에 담자(헉헉!)
		Item item = new Item();
		item.setProduct(product);
		item.setCount(1);
		cart.add(item);
		
		
		return "index";
	}
}
