package com.tka.Student.dao;
import java.util.List;


import org.hibernate.Session;
//import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.tka.Student.entity.Student;

@Repository
public class StudentDao {
     
	@Autowired
	SessionFactory factory;
	
	public String insertData(Student s) {
		
		Session session=factory.openSession();
		session.beginTransaction();
		session.persist(s);
		session.getTransaction().commit();
		session.close();
		return "Record is updated.....";
	}
	
	public String UpdateData(int id, Student f) {
		Session session=factory.openSession();
		session.beginTransaction();
		Student dbRecord=session.get(Student.class, id);
		dbRecord.setName(f.getName());
		dbRecord.setMobileno(f.getEmailid());
		dbRecord.setEmailid(f.getEmailid());
		
		session.merge(dbRecord);
		session.getTransaction().commit();
		session.close();
		return "Data id Updated.....";
	}
	
	public String deletData(int id) {
		Session session=factory.openSession();
		session.beginTransaction();
		Student s= session.get(Student.class, id);
		session.remove(s);
		session.getTransaction().commit();
		session.close();
		return "Record is Deleted Successfully";
	}
	public Student getParticularRecord(int id) {
		Session session=factory.openSession();
		session.beginTransaction();
		String hqlQuery="from Student where id=:myid";
		Query<Student>query=session.createQuery(hqlQuery,Student.class);
		query.setParameter("myid", id);
		Student p=query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return p;
	}
	
	public List<Student>getAllRecord(){
		Session session=factory.openSession();
		session.beginTransaction();
		
		String hqlQuery="from Person";
		Query<Student>query=session.createQuery(hqlQuery,Student.class);
		List<Student>list=query.list();
		session.getTransaction().commit();
		session.close();
		
		return list;
		
	}
}
