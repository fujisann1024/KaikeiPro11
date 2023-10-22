package com.example.demo.tutorial.component;

import org.springframework.stereotype.Component;

//独自に定義したクラスをBeanとして扱う
@Component
public class PostComponent {

	private String message = "default message.";
	
	public PostComponent() {
		super();
	}
	
	public String message() {
		return "message";
	}
	
	public void setMessage(String msg) {
		this.message = msg;
	}
}
