package com.tka.DataBaseAddress.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import com.tka.DataBaseAddress.entity.Address;

@Repository
public class AddressDao {

	@Autowired
	SessionFactory factory;
	
	public String insertdata(Address a) {
		Session session=factory.openSession();
		session.beginTransaction();
		session.persist(a);
		session.getTransaction().commit();
		session.close();
		return "Record is Saved.....................";
	}
	
	public String updateData(int id, Address a) {
		
		Session session=factory.openSession();
		session.beginTransaction();
		Address add=session.get(Address.class, id);
		add.setArea(a.getArea());
		add.setCity(a.getCity());
		session.merge(add);
		session.getTransaction().commit();
		session.close();
		return "data is updated...............";	
	}
	
	public String deleteData(int id) {
		Session session=factory.openSession();
		session.beginTransaction();
		Address add=session.get(Address.class, id);
		session.remove(add);
		session.getTransaction().commit();
		session.close();
		return "data is deleted.....";
		}
	
	public Address getParticularRecord(int id) {
		Session session=factory.openSession();
		session.beginTransaction();
		
		String hqlQuery="from Address where id=:myid";
		Query<Address>query=session.createQuery(hqlQuery,Address.class);
		query.setParameter("myid", id);
		Address a=query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return a;
		
	}
	
	public List<Address> getAllrecordById() {
		Session session=factory.openSession();
		session.beginTransaction();
		String hqlQuery="from Address";
		Query <Address>query=session.createQuery(hqlQuery,Address.class);
		List<Address>list=query.list();
		session.getTransaction().commit();
		session.close();
		return list;
		}
}
