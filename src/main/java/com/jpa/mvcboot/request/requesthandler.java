package com.jpa.mvcboot.request;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jpa.mvcboot.model.book;
import com.jpa.mvcboot.services.modelservice;

@Controller
public class requesthandler {
	@Autowired
	private modelservice service;
	//@ResponseBody
	ModelAndView mv=new ModelAndView();
	@GetMapping("/get")
	public ModelAndView getall()
	{
		//service.add();
		
		mv.addObject("books",service.getAll());
		mv.addObject("mode","Book_View");
		
		mv.setViewName("hello");
		return mv;
		 
	}
	@GetMapping("/update")
	public ModelAndView updateBook(@RequestParam("id") long id)
	{
		
		mv.addObject("mode","Book_Edit");
		mv.addObject("book",service.update(id));
		mv.setViewName("hello");
		return mv;
		//service.update(id);
	}
	@PostMapping("/edit")
	public ModelAndView editBook(@ModelAttribute book editbook)
	{
		service.edit(editbook);
		mv.addObject("books",service.getAll());
		mv.addObject("mode","Book_View");
		
		mv.setViewName("hello");
		return mv;
		//service.update(id);
	}
	@GetMapping("/delete")
	public ModelAndView deleteBook(@RequestParam long id)
	{
		service.delete(id);
		mv.addObject("books", service.getAll());
		mv.addObject("mode", "Book_View");
		mv.setViewName("hello");
		return mv;
	}
	@GetMapping("/add")
	public ModelAndView deleteBook()
	{
		
		mv.addObject("mode", "New_Book");
		//mv.addObject("books",service.getAll());
		mv.setViewName("hello");
		return mv;
	}
	
	/*@RequestMapping("/hello")
	public String hello()
	{
		return "hello";
	}*/

}
