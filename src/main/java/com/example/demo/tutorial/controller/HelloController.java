package com.example.demo.tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//コントローラーとして認識する
@Controller
public class HelloController {

	// 引数に指定されたパスにアクセスされたとき、付与されたメソッドを呼び出す
	@RequestMapping("/hello")
	public String disp() {
		// 指定したテンプレートを表示する
		return "tutorial/hello";
	}

	// URLから受け取ったパラメータによって表示を変える
	@RequestMapping("/{temp}")
	public String dispcheck(@PathVariable String temp) {

		if ("other".equals(temp)) {
			return "tutorial/other";
		}

		return "tutorial/hello";
	}
}
