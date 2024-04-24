package com.tka.Student.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.Student.dao.StudentDao;
import com.tka.Student.entity.Student;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;
	
	public String InsertData(Student s) {
		
		String sms=dao.insertData(s);
		return sms;
		
	}
	public String Updatedata(int id, Student p) {
		String msg=dao.UpdateData(id, p);
		return msg;
		
	}
	public String DeleteData(int id) {
	String msg=dao.deletData(id);
		return msg;
		
	}
	public Student getParticularRecord(int id) {
		Student p=dao.getParticularRecord(id);
		return p;
	}
	
	public List<Student>getAllRecord(){
	List<Student>list=dao.getAllRecord();
	return list;
}
}