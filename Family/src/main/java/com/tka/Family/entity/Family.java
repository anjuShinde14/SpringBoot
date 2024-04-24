package com.tka.Family.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Family {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String adrno;
	String pno;
	String dl;
	
   Family(){
		
	}
	public Family(int id, String adrno, String pno, String dl) {
		super();
		this.id = id;
		this.adrno = adrno;
		this.pno = pno;
		this.dl = dl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdrno() {
		return adrno;
	}
	public void setAdrno(String adrno) {
		this.adrno = adrno;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getDl() {
		return dl;
	}
	public void setDl(String dl) {
		this.dl = dl;
	}
	@Override
	public String toString() {
		return "Family [id=" + id + ", adrno=" + adrno + ", pno=" + pno + ", dl=" + dl + "]";
	}
	
	
}
