package com.tka.DataBaseAddress.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.DataBaseAddress.dao.AddressDao;
import com.tka.DataBaseAddress.entity.Address;

@Service
public class AddressService {
    @Autowired
	AddressDao dao;
	public String InsertData(Address a) {
		String sms=dao.insertdata(a);
		return sms;
	}
	
	public String UpdateData(int id,Address a) {
		String sms=dao.updateData(id, a);
		return sms;
	}
	
	public String DeleteData(int id) {
		String sms=dao.deleteData(id);
		return sms;
		
	}
	
	public Address getParticularRecord(int id) {
		Address a=dao.getParticularRecord(id);
		return a;
		
	}
	public List<Address>getAllRecord(){
		List<Address>list=dao.getAllrecordById();
		return list;
	}
}
