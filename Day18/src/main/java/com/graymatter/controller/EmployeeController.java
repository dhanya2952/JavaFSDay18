package com.graymatter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.graymatter.model.Employee;

@Controller
//@RequestMapping("/empctrl")
public class EmployeeController {
	
	@RequestMapping("/employee")
	public ModelAndView getEmpInfo()
	{
		Employee emp = new Employee("dhanya",1212,20000);
		ModelAndView mv =new ModelAndView("emp");
		mv.addObject("emp", emp);
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String uname, @RequestParam String pwd)
	{
		ModelAndView mv = null;
		if(uname.equals("dhanya") && pwd.equals("1212"))
		{
			mv= new ModelAndView("addEmp");
			//mv.addObject("uname", uname);
		}
		else
			mv= new ModelAndView("login");
		return mv;
		
	}
	
	@RequestMapping("/doLogin")
	public String doLogin()
	{
		return "login";
		
	}
	
	@RequestMapping("/employee/add")
	public ModelAndView addEmp(@RequestParam String empName, @RequestParam String empId, @RequestParam String empSal)
	{
		Employee e = new Employee(empName,Integer.parseInt(empId),Double.parseDouble(empSal));
		ModelAndView mv= new ModelAndView("emp");
		mv.addObject("emp", e);
		return mv;
	}

}
