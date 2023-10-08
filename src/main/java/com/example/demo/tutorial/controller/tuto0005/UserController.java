package com.example.demo.tutorial.controller.tuto0005;

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
}
