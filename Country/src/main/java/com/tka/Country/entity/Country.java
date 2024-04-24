package com.tka.Country.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Country {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cid;
	String city;
	
	Country(){
		
	}
	public Country(int cid, String city) {
		super();
		this.cid = cid;
		this.city = city;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Country [cid=" + cid + ", city=" + city + "]";
	}
}
