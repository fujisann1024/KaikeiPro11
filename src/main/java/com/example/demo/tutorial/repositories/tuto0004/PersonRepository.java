package com.example.demo.tutorial.repositories.tuto0004;

import java.util.List;
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
	
	//引数の値であいまい検索を行う※ワイルドカードは引数を渡す際に設定する
	public List<Person> findByNameLike(String name);
	
	//IDがNULL以外かつIDを降順で取得
	public List<Person> findByIdIsNotNullOrderByIdDesc();
	
	//ageの値が引数に指定した値よりも大きいものを検索
	public List<Person> findByAgeGreaterThan(Integer aeg);
	
	//ageの値が指定の範囲内のものを検索する
	public List<Person> findByAgeBetween(Integer age1, Integer age2);
}
