package com.tka.ProjectDemo.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.ProjectDemo.entity.Country;
import com.tka.ProjectDemo.entity.Employee;
import com.tka.ProjectDemo.service.MainService;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class MainController {
    
	@Autowired
	MainService service;
	
	@PostMapping("/addcountry")
	public String addCountry(@RequestBody Country c) {
	
		String msg=service.addCountry(c);
		return msg;
	}
	
	@PutMapping("/updatecountry")
	public String updateCountry(@RequestBody Country c) {
		String msg=service.UpdateData(c);
		return msg;
	}
	@DeleteMapping("/deletecountry")
	public String DeleteCountry(@RequestBody Country c) {
		String msg=service.DeleteCountry(c);
		return msg;
	}
	@GetMapping("/getparticularData/{id}")
	public Country getParticularRecord(@PathVariable int id) {
		Country c=service.getParticularRecordById(id);
		return c;
	}
	
	@GetMapping("/getallcontry")
	public List<Country>getAllCountry(){
		List<Country>list=service.getAllrecord();
		return list;
	}
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee e) {
		String msg=service.addEmployee(e);
		return msg;
	}
	
	@PutMapping("updateemp")
	public String updateEmployee(@RequestBody Employee e) {
		String msg=service.updateEmployee(e);
		return msg;
	}
	
	@DeleteMapping("deleterecord")
	public String DeleteEmployee(@RequestBody Employee e) {
		String msg=service.DeleteEmpRecord(e);
		return msg;
	}
	
	@GetMapping("/getpartihql/{id}")
	public Employee getParticularEmp(@PathVariable int id) {
		Employee msg=service.GetParticularEmp(id);
		return msg;
	}
	@GetMapping("/getallemp")
	public List<Employee>getAllEmp(){
		List<Employee>list=service.getAllData();
		return list;	
	}
	
//	@GetMapping("getallemployee")
//	public List<Employee> getAllEmploye() {
//		List<Employee>list=service.getAllEmployee();
//		return list;
//	}
	
//	@GetMapping("getParticularRById/{id}")
// 	public Employee getParticularEmpByID(@PathVariable int id) {
// 	Employee emp=service.getParticularEmpBy(id);
//		return emp;
//	}
//	
//	@GetMapping("getpartihql/{id}")
//	public Employee getParticularIdusinghql(@PathVariable int id) {
//		Employee emp=service.getParticularUsingHQL(id);
//		return emp;	
//	}
	
	@GetMapping("/getByStatus/{status}")
	public List<Employee> getAllEmpByStatus(@PathVariable String status) {
		
		List<Employee> list= service.getAllEmpByStatus(status);
		return list;
	}
	@PostMapping("/loginApi")
	public HashMap checkUser(@RequestBody Employee emp) {
		
		HashMap map= service.checkUser(emp);
		return map;
		
	}
	@PostMapping("/loginuser")
	public HashMap loginUser(@RequestBody User user) {
		
		HashMap map=service.loginUser(user);
		return map;
	}
}

