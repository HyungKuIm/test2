package com.oraclejava.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.oraclejava.domain.Item;

@Repository
public class JdbcPurchaseRepository implements PurchaseRepository {
	
	private JdbcTemplate jdbcTemplate;
	//1
	public JdbcPurchaseRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//2
	@Override
	public void insert(List<Item> cart, String name, String address) {
		String sql = "insert into purchase(id, "
				+ "product_id, product_count, customer_name, customer_address"
				+ ") values (purchase_seq.nextval, "
				+ "?,?,?,?)";
		for (Item item : cart) {
			jdbcTemplate.update(sql, 
					item.getProduct().getId(),
					item.getCount(),
					name,
					address);
		}
		
		
	}

	

}




