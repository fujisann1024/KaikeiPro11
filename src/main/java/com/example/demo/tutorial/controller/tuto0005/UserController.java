package com.example.demo.tutorial.controller.tuto0005;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.tutorial.dao.tuto0005.UserDAOUserImpl;
import com.example.demo.tutorial.entity.tuto0005.User;

@Controller
public class UserController {

	private static String path = "tutorial/tuto0005/";
	
	@Autowired
	UserDAOUserImpl dao;
	
	@RequestMapping(value="/tutorial/tuto0005/find", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.addObject("msg","検索画面");
		Iterable<User> list = dao.getAll();
		mav.addObject("data",list);
		mav.setViewName(path + "find");
		return mav;
	}
	
	@RequestMapping(value="/tutorial/tuto0005/find", method=RequestMethod.POST)
	public ModelAndView search(
			HttpServletRequest request
			,ModelAndView mav) {
		
		String param = request.getParameter("find_str");
		
		if("".equals(param)) {
			mav = new ModelAndView("redirect:find");
		}else {
			mav.addObject("title","Find result");
			mav.addObject("msg","「" + param + "」の検索画面");
			mav.addObject("value",param);
			List<User> list = dao.find(param);
			mav.addObject("data",list);
		}
		
		mav.setViewName(path + "find");
		return mav;
	}
	
	
}
