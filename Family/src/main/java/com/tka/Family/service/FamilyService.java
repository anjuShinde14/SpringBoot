package com.tka.Family.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.Family.dao.FamilyDao;
import com.tka.Family.entity.Family;

@Service
public class FamilyService {
    @Autowired
	FamilyDao dao;
	
    public String InsertData(Family f) {
    	
    	String msg=dao.insertData(f);
		return msg;
    	
    }
    public String Updatedata(int id, Family f) {
    	String sms=dao.updateData(id, f);
		return sms;
    	
    }
    
    public String DeletData(int id ) {
    	String msg=dao.deleteData(id);
    	return msg;
    }
    public Family getParticularRecord(int id) {
    	Family f=dao.getParticularRecord(id);
		return f;
    	
    }
    public List<Family>getAllRecord(){
    	List<Family>list=dao.getAllRecord();
    	return list;
    }
}
