package com.oraclejava.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.oraclejava.domain.Customer;

@Repository
public class JdbcCustomerRepository 
	implements CustomerRepository {

	private JdbcTemplate jdbcTemplate;
	
	
	
	public JdbcCustomerRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}



	@Override
	public Customer search(String login, String password) {
		String sql = "select * from customer\r\n"
				+ "  where login = ? and password = ?";
		try {
			return jdbcTemplate.queryForObject(sql, 
					this::mapRowToCusotmer, login, password);
		} catch (EmptyResultDataAccessException e) {
			System.out.println("그런 아이디나 패스워드는 없는데요");
			return null;
		}
	}
	
	
	private Customer mapRowToCusotmer(ResultSet rs, int rowNum)
		throws SQLException {
		return new Customer(
				rs.getInt("id"),
				rs.getString("login"),
				rs.getString("password")
				);
	}
	

}
