package com.tka.ProjectDemo.service;

import java.util.HashMap;

import java.util.List;
import java.util.Objects;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.ProjectDemo.dao.MainDao;
import com.tka.ProjectDemo.entity.Country;
import com.tka.ProjectDemo.entity.Employee;

@Service
public class MainService {
	@Autowired
	MainDao dao;

	public String addCountry(Country c) {
		String msg = dao.addCountry(c);
		if (Objects.isNull(msg)) {
			msg = "Data is not Addeds Successfully...";
		}
		return msg;
	}

	public String UpdateData(Country c) {
		String msg = dao.updateCountry(c);
		if (Objects.isNull(msg)) {
			msg = "Data is notAddeds......";
		}
		return msg;
	}

	public String DeleteCountry(Country c) {
		String msg = dao.deleteCountry(c);
		if (Objects.isNull(msg)) {
			msg = "Datais not Added successfully.........";
		}
		return msg;
	}
//	public Country getParticularRecord(int id) {
//		Country c1 = dao.GetParticularCountry(id);
//		if (Objects.isNull(c1)) {
//        c1=c;
//		}
//		return c1;
//	}
	
	public Country getParticularRecordById(int id) {
		Country c=dao.GetParticularCountry(id);
		return c;
	}

	public List<Country> getAllrecord() {
		List<Country>list=dao.getAllRecord();
		return list;
		
	}
	public String addEmployee(Employee e) {
		String msg = dao.addEmployee(e);
		if (Objects.isNull(msg)) {
			msg = "Record is not be added...";
		}
		return msg;
	}
	public String updateEmployee(Employee e) {
    	String msg=dao.UpdateEmploye(e);
    	if(Objects.isNull(msg)) {
    		msg="Record is not updated......";
    	}
		return msg;
    }
	public String DeleteEmpRecord(Employee e) {
		String msg=dao.deleteEmployee(e);
		if(Objects.isNull(msg)) {
			msg="Data is not deletede...";
		}
		return msg;
	}
	
	public Employee GetParticularEmp(int id) {
		Employee msg=dao. getParticularEmployee(id);
		return msg;
	}
	
	public List<Employee>getAllData(){
		List<Employee>list=dao.GetAllRecord();
	    return list;
	}

	public List<Employee> getAllEmpByStatus(String status) {
		List<Employee> list= dao.getAllEmpByStatus(status);
		if(Objects.isNull(list)) {
			list=null;
		}
		return list;
	}

public HashMap checkUser(Employee emp) {
		
		Employee e= dao.checkUser(emp);
		HashMap map=new HashMap();
		if(Objects.isNull(e)) {
			map.put("msg","Invalid User");
			map.put("user", e);
		}else {
			map.put("msg","Valid User");
			map.put("user", e);
	}
		
		
		return map;
		
	}
  public HashMap loginUser(User user) {
	  User e=dao.loginUser(user);
	  HashMap map=new HashMap();
	  if(Objects.isNull(e)){
		  map.put("msg", "Invalid User");
		  map.put("user", e);
	  }else {
		  map.put("msg", "Valid User");
		  map.put("user", e);
	  }
	return map;
  }

	
	
//	public List<Employee>getAllEmployee(){
//		List<Employee>list=dao.getAllEmployee();
//		return list;
//	}

//	public Employee getParticularEmpBy(int id) {
//		Employee e=dao.getParticularEmpById(id);
//		if(Objects.isNull(e)) {
//			e=null;
//		}
//		return e;
//	}
//	
//	public Employee getParticularUsingHQL(int id) {
//		Employee e=dao.getEmpById(id);
//		if(Objects.isNull(e)) {
//			e=null;
//		}
//		return e;
//	}
	
}
