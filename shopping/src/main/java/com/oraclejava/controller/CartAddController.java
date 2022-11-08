package com.oraclejava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String addCart(@RequestParam("id") Integer id, Model model) {
		System.out.println("cartAdd");
		Product product = this.productRepository.findOne(id);
		model.addAttribute("id", id);
		model.addAttribute("name", product.getName());
		model.addAttribute("price", product.getPrice());
		return "cart";
	}
}
