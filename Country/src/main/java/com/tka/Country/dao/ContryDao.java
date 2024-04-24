package com.tka.Country.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tka.Country.entity.Country;

import org.hibernate.query.Query;



@Repository
public class ContryDao {

	@Autowired
	SessionFactory factory;
	
	public String InsertData(Country c) {
		Session session=factory.openSession();
		session.beginTransaction();
		session.persist(c);
		session.getTransaction().commit();
		session.close();
		return "Record is saved.....";
	}
	
	public String updateData(int cid,Country c) {
		Session session=factory.openSession();
		session.beginTransaction();
		
		Country db=session.get(Country.class,cid);
		
		db.setCity(c.getCity());
	
		session.merge(db);
		
		session.getTransaction().commit();
		session.close();
		return "Record is updated..";
		}
	
	public String deletData(int cid) {
		
		Session session=factory.openSession();
		session.beginTransaction();
		Country c=session.get(Country.class, cid);
		session.remove(c);
		session.getTransaction().commit();
		session.close();
		return "Record is updated....";
		
	}
	
	public Country getPerticularRecord(int cid){
		
		Session session=factory.openSession();
		session.beginTransaction();
		
		String hqlQuery="from Country where cid=:myid";
		Query<Country> query=session.createQuery(hqlQuery,Country.class);
		query.setParameter("myid",cid);
		Country c= query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return c;
		
	}
	
	public List<Country> getAllRecord(int cid) {
		Session session=factory.openSession();
		session.beginTransaction();
		String hqlQuery="from Country";
		Query<Country>query=session.createQuery(hqlQuery,Country.class);
		List<Country>list=query.list();
		session.getTransaction().commit();
		session.close();
		return list;
		
	}
}