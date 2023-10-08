package com.example.demo.tutorial.entity.tuto0005;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //エンティティクラスを示すアノテーション
@Table(name="Tester") //エンティティクラスに割り当てられるテーブル
public class User {

	@Id
	private String id;
	
	private String name;
	
	private LocalDate birthday;
	
	private Double height;
	
	private Double weight;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthDay) {
		this.birthday = birthDay;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	
}
