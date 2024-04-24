package com.tka.demoDemoEmployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.tka.demoDemoEmployee.dao.EmployeDao;
import com.tka.demoDemoEmployee.entity.DemoEmployee;

@Service
public class EmployeeService {
    @Autowired
	 EmployeDao dao;
    
    public String InsertData(DemoEmployee e) {
    	String msg=dao.InnsertData(e);
		return msg;   			
    }
    
    public String UpdateData(int id, DemoEmployee e) {
    	String msg=dao.updateData(id, e);
		return msg;
    }
    
    public String DeleteData(int id) {
		String msg=dao.deleteData(id);
    	return msg;
    }
    
    public DemoEmployee getParticularRecord(int id) {
		DemoEmployee e=dao.getParticularRecord(id);
    	return e;	
    }
    
    public List<DemoEmployee>getAllRecord(){
    	List<DemoEmployee>list=dao.getAllRecord();
    	return list;
    }

	
}
