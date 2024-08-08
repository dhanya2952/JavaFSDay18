package com.graymatter.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.graymatter.model.Student;

@Controller
public class StudentController {
	
	static List<Student> list = new ArrayList<>();
	
	StudentController() {
		Student s= new Student("asd",1,"123321122");
		list.add(s);
	}
	@RequestMapping("/doLogin")
	public String doLogin() {
	    return "login";
	}
	
	@RequestMapping("/home")
	public String home() {
	    return "home";
	}

	@RequestMapping("/add")
	public String add() {
		return "add";
	}

	@RequestMapping("/delete")
	public String delete() {
		return "delete";
	}
	
	@RequestMapping("/update")
	public String update() {
		return "update";
	}
	
	@RequestMapping("/login")	//this should matches with the jsp action
	public ModelAndView login(@RequestParam String uname, @RequestParam String pwd) {
		ModelAndView mv=null;
		if(uname.equals("admin") && pwd.equals("1212")) {
			mv=new ModelAndView("home");
			mv.addObject("name", uname);
		} else
			mv=new ModelAndView("login");
		return mv;
	}
	
	@RequestMapping(value="/add/addStudent", method=RequestMethod.POST)
	public String addStudent(@RequestParam String name,@RequestParam String id,@RequestParam String mobile ) {
		Student st = new Student(name,Integer.parseInt(id), mobile);
		list.add(st);
		return "redirect:/home";
	}

	@RequestMapping(value = {"/viewAll"}, method = RequestMethod.GET)
	public ModelAndView viewAll() {
		ModelAndView mv=new ModelAndView("stud");
		mv.addObject("list", list);
		mv.addObject("test", "viewAll");
		return mv;
	}
	
	@RequestMapping("/deleteStudent")
	public ModelAndView deleteStudent(@RequestParam String id) {
		int studId=Integer.parseInt(id);
		Iterator<Student> iterator = list.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			if (student.getId() == studId) {
				iterator.remove();
				break;
			}
		}
		return new ModelAndView("home");
	}
	
	@RequestMapping("/updateStudent")
	public ModelAndView updateStudent(@RequestParam String name,@RequestParam String id,@RequestParam String mobile) {
		int studId=Integer.parseInt(id);
		for (Student s : list) {
			if(s.getId()==studId){
				s.setName(name);
				s.setMobile(mobile);
				break;
			}	
		}
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	
}