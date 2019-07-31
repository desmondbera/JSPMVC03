package com.jdbSpringMVC03.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.jdbSpringMVC03.entities.Employee;
import com.jdbSpringMVC03.services.EmployeeService;

@Controller
@SessionAttributes("sEmployee")
public class MainController {
	
	@ModelAttribute("sEmployee")
	public Employee setUpEmployee() {
		Employee emp = new Employee(555, "DB", "BC", "DB@GMAIL.COM");
		return emp;
	}
	
	@RequestMapping(value = {"/", "/index"})
	public ModelAndView showIndex(@ModelAttribute("sEmployee") Employee empP) {
		
		EmployeeService empServ = new EmployeeService();
//		Employee vEmp = new Employee();
		
		System.out.println("*****BEFORE P EMP = " + empP.toString());
		
		empP = empServ.getEmployeeById(123);
		System.out.println("*** AFTER V EMP = " + empP.toString());
		
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("sEmployee", empP);
		return mav;
	}
	
	@RequestMapping("/addEmployee")
	public ModelAndView insertEmployee(@ModelAttribute Employee emp) {
		ModelAndView mav = new ModelAndView("index");
		
//		Employee emp = new Employee(55, "desmond", "beramendi", "des@gmail.com");
		
		EmployeeService empServ = new EmployeeService();
		boolean result = empServ.addEmployee(emp);
		
		String message = result ? "employee saved" : "not saved. try again";
		
		mav.addObject("messageResult", message);
		mav.setViewName("employeeProfile");
		return mav;
	}
	
	@RequestMapping("/showEmployees")
	public ModelAndView showAllEmployees() {
		
		EmployeeService empServ = new EmployeeService();
		List<Employee> empList = empServ.getAllEmployees();
		
		ModelAndView mav = new ModelAndView("allEmployees");
		mav.addObject("empList",empList);
		return mav;
	}
	
	@RequestMapping("/removeEmployee/{id}")
	public ModelAndView removeEmployeeById(@PathVariable int id) {
//		System.out.println("id: " + id);
		//Delete Employee by Id
		EmployeeService empServ = new EmployeeService();
		boolean empRemoved = empServ.removeEmployeeByIdService(id);
		
		String message = empRemoved ? "Employee removed." :"Employee not deleted yet.";
		
		List<Employee> empList = empServ.getAllEmployees();
		
		
		ModelAndView mav = new ModelAndView("allEmployees");
		mav.addObject("messageResult", message);
		mav.addObject("empList", empList);
		return mav;
	}
	
	@RequestMapping("/updateEmployee/{id}")
	public ModelAndView updatedEmployeeById(@PathVariable int id) {
		System.out.println("id: " + id);
		//Find Employee by Id
		EmployeeService empServ = new EmployeeService();
		Employee foundEmployee = empServ.getEmployeeById(id);		

		ModelAndView mav = new ModelAndView("editEmployee");
		mav.addObject("emp", foundEmployee);
		return mav;
	}
	
	@RequestMapping("/registerEmployee")
	public ModelAndView registerEmployee() {
		
		ModelAndView mav = new ModelAndView("employeeRegistration");
		return mav;
	}
	
	
	@RequestMapping("/saveEmployee") 
	public ModelAndView saveEmployee(@ModelAttribute Employee emp) {
		boolean result = true;
		
		EmployeeService empServ = new EmployeeService();
		if(emp != null) {
			result = empServ.updatedEmployee(emp);
		}
//		boolean empUpdated = empServ.updatedEmployee(emp);
		String message = result ? "Employee Updated: "+  emp.getId() : "Employee not updated.";	
		List<Employee> empList = empServ.getAllEmployees();
	
		ModelAndView mav = new ModelAndView("allEmployees");
		mav.addObject("messageResult", message);
		mav.addObject("empList", empList);
		return mav;
	}
}
