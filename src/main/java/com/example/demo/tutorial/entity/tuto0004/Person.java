package com.example.demo.tutorial.entity.tuto0004;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity //エンティティクラスを示すアノテーション
@Table(name="people") //エンティティクラスに割り当てられるテーブル
public class Person {
	
	@Id //プライマリーキーを示す
	//@GeneratedValue(strategy=GenerationType.AUTO) //値を自動生成する
	@Column(length = 10, nullable = true)
	@NotNull
	private String id; //ID
	
	@Column(length = 50, nullable = true)
	@NotBlank
	private String name; //名前
	
	@Column(length = 200, nullable = true)
	@Email
	private String mail; //メールアドレス
	
	@Column(nullable = true)
	@Min(0)
	@Max(200)
	private  Integer age; //年齢
	
	@Column(nullable = true)
	private String memo; //メモ

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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	

}
