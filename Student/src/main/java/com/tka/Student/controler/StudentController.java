package com.tka.Student.controler;


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

import com.tka.Student.entity.Student;
import com.tka.Student.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentService service;
   
	@PostMapping("savedata")
	public String savrRecord(@RequestBody Student s) {
	
	 String sms=service.InsertData(s);
	 return sms;
	}
	@PutMapping("/updatedata/{id}")
	public String UpdateData(@PathVariable int id) {
		String msg=service.DeleteData(id);
		return msg;
		
	}
	@DeleteMapping("/deleteData/{id}")
	public  String DeletMapping(@PathVariable int id) {
		String msg=service.DeleteData(id);
		return msg;
	}
	@GetMapping("/getparticulardata/{id}")
	public Student getParticularRecordById(@PathVariable int id) {
		Student s=service.getParticularRecord(id);
		return s;
		
	}
	@GetMapping("/getAll")
	public List<Student>getAllRecord(){
		List<Student>list=service.getAllRecord();
		return list;
	}
}

