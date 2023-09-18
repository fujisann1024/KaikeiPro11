package com.example.demo.tutorial.controller.tuto0002;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SurveryController {

	private static String path = "tutorial/tuto0002/";

	// 画面表示時にView側のmsg変数に値を渡す
	@RequestMapping(value = "tutorial/tuto0002/survey", method = RequestMethod.GET)
	public ModelAndView getIndex(ModelAndView mav) {
		mav.addObject("msg", "フォームを送信してください");
		mav.setViewName(path + "survey");
		return mav;
	}

	//requireで必須かどうかを判定
	@RequestMapping(value = "tutorial/tuto0002/survey")
	public ModelAndView form(@RequestParam(value = "check1", required = false) boolean check1,
			@RequestParam(value = "radio1", required = false) String radio1,
			@RequestParam(value = "select1", required = false) String select1,
			@RequestParam(value = "select2", required = false) String[] select2, ModelAndView mav) {
		StringBuilder res = new StringBuilder();
		
		res.append("check:").append(check1)
		   .append(",radio:").append(radio1)
		   .append(",select1:").append(select1)
		   .append(",select2:");

		try {
			res.append(select2[0]);
			
			for(int i = 1; i < select2.length; i++) {
				res.append(",").append(select2[i]);
			}
			
		} catch (NullPointerException e) {
			res.append("null");
		}
		
		mav.addObject("msg",res.toString());
		mav.setViewName(path + "survey");
		
		return mav;
	}

}
