package com.tka.demoDemoEmployee.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.demoDemoEmployee.entity.DemoEmployee;

@Repository
public class EmployeDao {
    @Autowired
	SessionFactory factory;
	
	public String InnsertData(DemoEmployee e) {
	
	Session session= factory.openSession();
	session.beginTransaction();
	session.persist(e);
	session.getTransaction().commit();
	session.close();
	return "Record is Inserted";
	}
	
	public String updateData(int id, DemoEmployee a) {
		
		Session session=factory.openSession();
		session.beginTransaction();
		
		DemoEmployee dbRecord=session.get(DemoEmployee.class, id);
		dbRecord.setName(a.getName());
		dbRecord.setEmailid(a.getEmailid());
		dbRecord.setMobailno(a.getMobailno());
		session.merge(dbRecord);
		session.getTransaction().commit();
		session.close();
		return "Record id updated......";
		}
	
	public String deleteData(int id) {
		Session session=factory.openSession();
		session.beginTransaction();
		DemoEmployee e=session.get(DemoEmployee.class, id);
		session.remove(e);
		session.getTransaction().commit();
		session.close();
		return "Record is deleted successfully";
	}
	
	public DemoEmployee getParticularRecord(int id){
		
		Session session=factory.openSession();
		session.beginTransaction();
		
		String hqlQuery="from DemoEmployee where id=:myid";
		Query<DemoEmployee>query=session.createQuery(hqlQuery,DemoEmployee.class);
		query.setParameter("myid", id);
		
		DemoEmployee e=query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return e;
	}
	public List<DemoEmployee> getAllRecord() {
		Session session=factory.openSession();
		session.beginTransaction();
		String hqlQuery="from DemoEmployee";
		Query<DemoEmployee>query=session.createQuery(hqlQuery,DemoEmployee.class);
		List<DemoEmployee>list=query.list();
		session.getTransaction().commit();
		session.close();
		return list;
		}

	
}
