package com.graymatter.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
	
	//map to apis when a request is sent for the url
//	@RequestMapping("/hello")
//	public String sayHello()
//	{
//		return "hello";
//	}
	
	@RequestMapping("/hello")
	public String printnm(Model model)
	{
		model.addAttribute("username", "dhanya..");
		return "hello";
	}
	
	@RequestMapping("/name")
	public ModelAndView printName(String name)
	{
		ModelAndView mv = new ModelAndView("dhanya");
		name="dhanya";
		mv.addObject("name", name);
		return mv;
		
		
	}

}
