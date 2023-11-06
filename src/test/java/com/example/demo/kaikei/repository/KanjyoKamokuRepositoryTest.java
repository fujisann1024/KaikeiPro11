package com.example.demo.kaikei.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

@JdbcTest
@Import(KanjyoKamokuRepository.class)
class KanjyoKamokuRepositoryTest {

	@Autowired
	KanjyoKamokuRepository reposiory;
	
	@BeforeEach
	void setUp() {
		
	}

	@Test
	void test() {
		fail("まだ実装されていません");
	}

}
