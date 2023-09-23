package com.example.demo.tutorial.repositories.tuto0004;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.tutorial.entity.tuto0004.Person;

/**
 * 第一引数～エンティティの型
 * 第二引数～プライマリーキーの型
 * */
@Repository //データアクセスかを示すアノテーション
public interface PersonRepository extends JpaRepository<Person, String> {

	public Optional<Person> findById(String name);
}
