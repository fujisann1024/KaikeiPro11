package com.example.demo.tutorial.controller.tuto0002;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostingFormController {

	private static String path = "tutorial/tuto0002/";
	
	//画面表示時にView側のmsg変数に値を渡す
	@RequestMapping(value="tutorial/tuto0002/postTest",method=RequestMethod.GET)
	public ModelAndView getIndex(ModelAndView mav) {
		mav.addObject("msg","名前を書いてください");
		mav.setViewName(path + "postTest");
		return mav;
	}
	
	//POST送信時にView側のmsg、value変数に値を渡す
	@RequestMapping(value="tutorial/tuto0002/postTest",method=RequestMethod.POST)
	public ModelAndView postIndex(@RequestParam("text1") String name, ModelAndView mav) {
		mav.addObject("msg","こんにちは" + name + "さん");
		mav.addObject("value",name);
		mav.setViewName(path + "postTest");
		return mav;
	}
	
	
	
}
