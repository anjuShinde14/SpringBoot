package com.tka.demoDemoEmployee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DemoEmployee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 int id;
 String name;
 @Column(unique=true)
 String emailid;
 String mobailno;
 
 DemoEmployee(){
	 
 }

public DemoEmployee(String name, String emailid, String mobailno) {
	super();
	this.name = name;
	this.emailid = emailid;
	this.mobailno = mobailno;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmailid() {
	return emailid;
}

public void setEmailid(String emailid) {
	this.emailid = emailid;
}

public String getMobailno() {
	return mobailno;
}

public void setMobailno(String mobailno) {
	this.mobailno = mobailno;
}

@Override
public String toString() {
	return "DemoEmployee [id=" + id + ", name=" + name + ", emailid=" + emailid + ", mobailno=" + mobailno + "]";
}
	
}
