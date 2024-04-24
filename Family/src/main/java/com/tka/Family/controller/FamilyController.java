package com.tka.Family.controller;

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

import com.tka.Family.entity.Family;
import com.tka.Family.service.FamilyService;

@RestController
@RequestMapping("api")
public class FamilyController {
    @Autowired
	FamilyService service;
	
    @PostMapping("/savedata")
    public String saveRecord(@RequestBody Family f) {
    	String msg=service.InsertData(f);
		return msg;
	}
    @PutMapping("/updatedata{id}")
    public String UpdateRecords(@PathVariable int id,@RequestBody Family f) {
		String sms=service.Updatedata(id, f);
    	return sms;
    }
    @DeleteMapping("/deleteData/{id}")
    public Family deletRecord(@PathVariable int id) {
		Family msg=service.getParticularRecord(id);
    	return msg;
    }
    @GetMapping("/getParticulardata/{id}")
    public Family getParticularRecordById(@PathVariable int id) {
    	 Family f=service.getParticularRecord(id);
		return f;
   }
    @GetMapping("/getAll")
    public List<Family>getAllRecord(){
    	List<Family>list=service.getAllRecord();
		return list;
    }
}
