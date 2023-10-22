package com.example.demo.tutorial.controller.tuto0006;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.tutorial.component.PostComponent;
import com.example.demo.tutorial.service.PostService;
import com.example.demo.tutorial.entity.tuto0006.PostEntity;

@Controller
public class BeanController {
	
	private static String path = "tutorial/tuto0006/";
	
	@Autowired
	PostEntity entity;
	
	@Autowired
	PostComponent component;
	
	@Autowired
	PostService service;
	

	@Value("${samplesapp.message}")
	private String message;

	
	@RequestMapping("/tutorial/tuto0006/bean")
	public ModelAndView bean(ModelAndView mav) {
		mav.setViewName(path +"bean");
		mav.addObject("title","Bean Sample");
		mav.addObject("entity",entity);
		mav.addObject("component",component.message());
		mav.addObject("data",service.getAllPostsJson());
		mav.addObject("msg",message);
		return mav;
	}
	
	@RequestMapping(value = "/tutorial/tuto0006/bean", method = RequestMethod.POST)
	public ModelAndView bean(
			HttpServletRequest request,
			ModelAndView mav) {
		
		String param = request.getParameter("find_str");
		if(Objects.isNull(param)) { param = ""; }
		mav.setViewName(path +"bean");
		mav.addObject("title","Bean Sample");
		mav.addObject("entity",entity);
		mav.addObject("component",component.message());
		mav.addObject("msg",message + " get id = " + param);
		PostEntity entity = service.getPostsJson(Integer.parseInt(param));
		mav.addObject("data", new PostEntity[] {entity});
		return mav;
	}
}
