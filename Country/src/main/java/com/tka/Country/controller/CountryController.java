package com.tka.Country.controller;

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

import com.tka.Country.entity.Country;
import com.tka.Country.service.ServiceCountry;

@RestController
@RequestMapping("/api")
public class CountryController {
    @Autowired
	ServiceCountry service;
    
	@PostMapping("savedata")
    public String saveRecord(@RequestBody Country c) {
    	String sms=service.InsertData(c);
    	return sms;
    } 
	
	@PutMapping("/updatedata/{id}")
	public String Updaterecord(@PathVariable int id, @RequestBody Country c) {

		String sms=service.UpdateData(id, c);
		return sms;
	
		}	
	@DeleteMapping("/deletedata/{id}")
	public String DeleteRecord(@PathVariable int id) {
		String sms=service.DeleteData(id);
		return sms;
	}
	@GetMapping("getdata/{id}")
	public Country getParticularRecordById(@PathVariable int id) {
		Country c=service.getparticularRecord(id);
		return c;	
	}
	@GetMapping("/getAll")
	public List<Country>getAllrecord(){
		List<Country>list=service.GetAllRecord();
		return list;
	}
}
