package com.tka.Country.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.tka.Country.dao.ContryDao;
import com.tka.Country.entity.Country;

@Service
public class ServiceCountry {
    @Autowired
	 ContryDao dao;
    
    public String InsertData(Country c) {
    	String sms=dao.InsertData(c);
    	return sms;	
    }
    
    public String UpdateData(int cid, Country c) {
    	String msg=dao.updateData(cid, c);
    	return msg;
    }
    
    public String DeleteData(int cid) {
    	String msg=dao.deletData(cid);
		return msg;
    	
    }
    
    public Country getparticularRecord(int cid) {
		Country c=dao.getPerticularRecord(cid);
    	return c;
    	
    }

	public List<Country> GetAllRecord() {
		List<Country>list=dao.getAllRecord(0);
		return list;
	}
   
}
