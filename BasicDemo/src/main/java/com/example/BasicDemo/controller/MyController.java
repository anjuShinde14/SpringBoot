package com.example.BasicDemo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

	@RequestMapping("/firstapi")
public String myfirstApi() {
    return" Ur first Api is called";
}
	
	@RequestMapping(value="/secondapi",method=RequestMethod.POST)
	public String mysecondApi() {
		return "U called Post API";
	}
	
	@RequestMapping(value="/putapi",method=RequestMethod.PUT)
	public String myputApi() {
		return"U Called put API";
	}

	
	@RequestMapping(value = "/deleteapi",method = RequestMethod.DELETE)
	public String myDeleteApi() {
		return "U called Delete API ";
	}
	
	@GetMapping("/getmappingApi")
	public String getMapping() {
		return "get mapping is called...";
	}
	
	@PostMapping("/postmappingApi")
	public String postMapping() {
		return "post mapping is called...";
	}
	
	@PutMapping("/putmappingApi")
	public String putMapping() {
		return "put mapping is called";
	}
	
	@DeleteMapping("/deletemappingApi")
	public String deletemapping() {
		return"Delete mapping is called";
	}
}