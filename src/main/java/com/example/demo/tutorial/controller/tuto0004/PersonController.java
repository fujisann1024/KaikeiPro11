package com.example.demo.tutorial.controller.tuto0004;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	//画面表示用
	@RequestMapping("/tutorial/tuto0004/index")
	public ModelAndView index(
			@ModelAttribute("formModel") Person person
			,ModelAndView mav) {
		
		mav.addObject("title","Hello page");
		mav.addObject("msg","this is JPA sample data.");
		
		Iterable<Person> list = repository.findAll();
		mav.addObject("data",list);
		mav.setViewName(path + "index");
		return mav;
	}
	
	//登録用
	@RequestMapping(value="tutorial/tuto0004/index",method=RequestMethod.POST)
	@Transactional //データベースの更新などの一貫性を保証する
	public ModelAndView form(
			@ModelAttribute("formModel") //画面から受け取った値をセットしたインスタンスを自動的に生成 
			@Validated Person person //エンティティの値をバリデーションチェックするため
			,BindingResult result //Errorsというインターフェースを継承するサブインターフェース
			,ModelAndView mav) {
		ModelAndView res = null;
		System.out.println(result.getFieldErrors());
		
		if(!result.hasErrors()) {
			repository.saveAndFlush(person);
			res = new ModelAndView("redirect:index");			
		}else {
			mav.addObject("title","Hello page");
			mav.addObject("msg","this is JPA sample data.");
			
			Iterable<Person> list = repository.findAll();
			mav.addObject("data",list);
			mav.setViewName(path + "index");	
			res = mav;
		}
		
		return res;

	}
	
	//編集画面表示用
	@RequestMapping(value="tutorial/tuto0004/edit/{id}",method=RequestMethod.GET)
	public ModelAndView edit(
			@ModelAttribute Person person
		  , @PathVariable String id
		  , ModelAndView mav
		  ) {
		
		mav.addObject("title","edit Person");
		Optional<Person> data = repository.findById(id);
		mav.addObject("formModel", data.get());
		mav.setViewName(path + "edit");
		return mav;
	}
	
	//更新用
	@RequestMapping(value="tutorial/tuto0004/edit",method=RequestMethod.POST)
	@Transactional //データベースの更新などの一貫性を保証する
	public ModelAndView update(
			@ModelAttribute("formModel") Person person
			,ModelAndView mav) {
		repository.saveAndFlush(person);
		return new ModelAndView("redirect:/tutorial/tuto0004/index");
	}
	
	//削除画面表示用
	@RequestMapping(value="tutorial/tuto0004/delete/{id}",method=RequestMethod.GET)
	public ModelAndView delete(
			 @PathVariable String id
		  , ModelAndView mav
		  ) {
		
		mav.addObject("title","Delete Person.");
		mav.addObject("msg","Can I delete this record?");
		Optional<Person> data = repository.findById(id);
		mav.addObject("formModel", data.get());
		mav.setViewName(path + "delete");
		return mav;
	}
	
	//削除用
	@RequestMapping(value="tutorial/tuto0004/delete",method=RequestMethod.POST)
	@Transactional //データベースの更新などの一貫性を保証する
	public ModelAndView remove(
			@RequestParam String id
			,ModelAndView mav) {
		repository.deleteById(id);
		return new ModelAndView("redirect:/tutorial/tuto0004/index");
	}
}
