package com.example.demo.tutorial.controller.tuto0003;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class dispController {

	private static String path = "tutorial/tuto0003/";
	
	private static boolean flag = false;
	
	//画面表示時にView側のmsg変数に値を渡す
	@RequestMapping(value="tutorial/tuto0003/disp")
	public ModelAndView getIndex(ModelAndView mav) {
		mav.addObject("msg","メッセージです");
		//アクセスするごとに表示が変わる
		flag = !flag;
		//ｔｈ:ifによる条件分岐の制御
		mav.addObject("flag",flag);
		
		String[] data = new String[] {"One","Two","Three"};
		//ｔｈ:eachによる繰り返しの制御
		mav.addObject("data",data);
		mav.setViewName(path + "disp");
		return mav;
	}
}
