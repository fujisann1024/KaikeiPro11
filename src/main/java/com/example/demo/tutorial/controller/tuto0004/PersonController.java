package com.example.demo.tutorial.controller.tuto0004;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.tutorial.entity.tuto0004.Person;
import com.example.demo.tutorial.repositories.tuto0004.PersonRepository;

@Controller
public class PersonController {
	
	private static String path = "tutorial/tuto0004/";
	
	/**
	 * 1,アプリケーション起動時に,@Repositoryをつけられたインターフェースを検索し、自動的に
	 * その実装クラスが作成され、さらにそのインスタンスがアプリケーションにBeanとして登録される
	 * 2,コントローラーなどのクラスがロードされる際、@Autowiredが指定されているフィールド
	 * があると、登録済みのBeanから同じクラスのものを検索し、自動的にそのフィールドにインスタンスを割り当てる
	 * */
	@Autowired
	PersonRepository repository;

	@RequestMapping("/tutorial/tuto0004/index")
	public ModelAndView index(ModelAndView mav) {
		
		mav.addObject("title","Hello page");
		mav.addObject("msg","this is JPA sample data.");
		
		Iterable<Person> list = repository.findAll();
		mav.addObject("data",list);
		mav.setViewName(path + "index");
		return mav;
	}
}
