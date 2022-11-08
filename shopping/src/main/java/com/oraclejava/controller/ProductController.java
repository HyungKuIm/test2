package com.oraclejava.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oraclejava.domain.Product;
import com.oraclejava.repository.ProductRepository;

@Controller
public class ProductController {
	
	private ProductRepository productRepository;
	
	// 의존성 주입(D.I.)
	public ProductController(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@RequestMapping("/product")
	public String productList(
			@RequestParam(value="keyword", required = false) String keyword,
			Model model) {
		if (keyword == null) keyword = "";  // 키워드가 없으면 전체 검색
		List<Product> list = productRepository.search(keyword);
		model.addAttribute("list", list);
		model.addAttribute("contents", "product :: productView");
		return "index";
	}

	
}




