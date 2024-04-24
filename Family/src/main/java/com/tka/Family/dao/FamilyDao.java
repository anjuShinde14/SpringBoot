package com.tka.Family.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.Family.entity.Family;

@Repository
public class FamilyDao {
    @Autowired
	SessionFactory factory;
	
    public String insertData(Family f) {
    	Session session=factory.openSession();
    	session.beginTransaction();
    	session.persist(f);
    	session.getTransaction().commit();
    	session.close();
		return "record is saved...............";	
    }
    public String updateData(int id, Family f) {
    	Session session=factory.openSession();
    	session.beginTransaction();
    	Family dbRecord=session.get(Family.class,id);
    	dbRecord.setAdrno(f.getAdrno());
    	dbRecord.setPno(f.getPno());
    	dbRecord.setDl(f.getDl());
    	
    	session.merge(dbRecord);
    	session.getTransaction().commit();
    	session.close();
		return "record is updated..........";
    }
    
    public String deleteData(int id) {
    	Session session=factory.openSession();
    	session.beginTransaction();
    	Family f=session.get(Family.class, id);
    	session.remove(f);
    	session.getTransaction().commit();
    	session.close();
    	return"Record id Deleted Succrssfully";
    }
    public Family getParticularRecord(int id) {
    	Session session=factory.openSession();
    	session.beginTransaction();
    	String hqlQuery="from Family where id=:myid";
    	Query<Family>query=session.createQuery(hqlQuery,Family.class);
		query.setParameter("myid", id);
		Family f=query.uniqueResult();
		session.getTransaction().commit();
		session.close();
    	return f;
   }
    public List<Family>getAllRecord(){
    	Session session=factory.openSession();
    	session.beginTransaction();
    	String hqlQuery="from Family";
    	Query<Family>query=session.createQuery(hqlQuery,Family.class);
    	List<Family>list=query.list();
    	session.getTransaction().commit();
    	session.close();
    	return list;
    }
}
