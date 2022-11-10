package com.oraclejava.repository;

import java.util.List;

import com.oraclejava.domain.Item;

public interface PurchaseRepository {
	void insert(List<Item> cart, String name, String address);
}
