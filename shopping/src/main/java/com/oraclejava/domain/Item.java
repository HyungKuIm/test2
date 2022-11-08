package com.oraclejava.domain;

import java.io.Serializable;

//장바구니 아이템
public class Item implements Serializable {
	private Product product; // 신라면
	private int count; // 2개
	
	// get, set
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
