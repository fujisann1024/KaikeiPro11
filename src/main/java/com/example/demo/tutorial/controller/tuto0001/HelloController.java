package com.example.demo.tutorial.controller.tuto0001;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//コントローラーとして認識する
@Controller
public class HelloController {

	private static String path = "tutorial/tuto0001/";
	
	// 引数に指定されたパスにアクセスされたとき、付与されたメソッドを呼び出す
	@RequestMapping("/tutorial/tuto0001/hello")
	public String disp() {
		// 指定したテンプレートを表示する
		return path + "hello";
	}

	// URLから受け取ったパラメータによって表示を変える
	@RequestMapping("/tutorial/tuto0001/{temp}")
	public String dispcheck(@PathVariable String temp) {

		if ("other".equals(temp)) {
			return  path + "other";
		}

		return path + "hello";
	}
	
	//画面に値を渡す処理
	@RequestMapping("/tutorial/tuto0001/{num}")
	public ModelAndView getMessage(ModelAndView mav, @PathVariable int num) {
		
		int value = 0;
		for(int i = 1; i <= 10; i++) {
			value = num * i + value;
		}
		
		//モデルとビューの情報をまとめて管理することで可読性があがる
		mav.addObject("msg","パラメータ × 1~10の総和");
		mav.addObject("content","コントローラーメッセージ:" + value);
		mav.setViewName(path + "modelCatch");
		return mav;
	}
}
