package com.example.demo.kaikei.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class KanjyoKamokuRepositoryImpl implements KanjyoKamokuRepository {

	private final JdbcTemplate jdbcTemplate;
	
	public KanjyoKamokuRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
