package com.example.BasicDemo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BasicDemo.entity.Employee;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
     
	 @PostMapping("/saveEmp")
	 public String SaveRecord(@RequestBody Employee emp) {
		 
		 System.out.println(emp);
		return "Record is Received...."+emp;
		 
	 }
	 
	 @PutMapping("/updateemp/{id}")
	 public String UpdateRecord(@PathVariable int id, @RequestBody Employee emp) {
		 
		 System.out.println("Id id"+id+"Employee data"+emp);
		 return "record is updated";
	 }
	 
	 @DeleteMapping("/deleteApi/{id}")
	
	 public String DeleteRecord(@PathVariable int id) {
		 System.out.println(id);
		return "Record is deleted"+id;
		 
	 }
	 @PutMapping("/updateemp1")
	 public String UpdateRecord1 (@RequestParam("id")int id,@RequestBody Employee emp) {
		 System.out.println("id is"+id+"Employee data"+emp);
		 return"Record is updated";
	 }
}
