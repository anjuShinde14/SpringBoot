package com.tka.DataBaseAddress.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.DataBaseAddress.entity.Address;
import com.tka.DataBaseAddress.service.AddressService;

@RestController
@RequestMapping("/api")
public class AddressController {
   @Autowired
	AddressService service;
	
   @PostMapping("savedata")
   public String saveRecord(@RequestBody Address a) {
	   
	   String sms=service.InsertData(a);
	return sms;
	   }
   @PutMapping("/updatedata/{id}")
   public String updatearecords(@PathVariable int id,@RequestBody Address addr) {
	  String sms=service.UpdateData(id, addr);
	   return sms;
	   
   }
   @DeleteMapping("/deleteRecord/{id}")
   public String deleteData(@PathVariable int id) {
	   String sms=service.DeleteData(id);
	   return sms;
	   
   }
   @GetMapping("/getparticular/{id}")
   public Address getdata(@PathVariable int id) {
	   Address a=service.getParticularRecord(id);
	return a;
   }
   
   @GetMapping("/getAll")
   public List<Address>getAllRecord(){
	List<Address>list=service.getAllRecord();
	   return list;
	   
   }
}
