package com.tka.demoDemoEmployee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.demoDemoEmployee.entity.DemoEmployee;
import com.tka.demoDemoEmployee.service.EmployeeService;

@RestController
@RequestMapping("emp")
public class EmployeeController {
   @Autowired
	EmployeeService service;
	
	@PostMapping("savedata")
	public String saveRecord(@RequestBody DemoEmployee e) {
		String msg=service.InsertData(e);
		return msg;
	}
	
	@PutMapping("/updatedata/{id}")
	public String UpdateRecords(@PathVariable int id,@RequestBody DemoEmployee e) {
		String sms=service.UpdateData(id, e);
		return sms;
		}
	@DeleteMapping("/delet/{id}")
	public String deleteData(@PathVariable int id) {
		String sms=service.DeleteData(id);
		return sms;
		}
	@GetMapping("/getparticulardata/{id}")
	public DemoEmployee getParticularRecordById(@PathVariable int id) {
		DemoEmployee e=service.getParticularRecord(id);
		return e;
		
	}
	@GetMapping("/getAll")
	public List<DemoEmployee>getAllRecord() {
		List<DemoEmployee>list=service.getAllRecord();
		return list;
		
	}
}
