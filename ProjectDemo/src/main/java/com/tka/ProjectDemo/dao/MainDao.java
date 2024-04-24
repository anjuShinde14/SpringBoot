package com.tka.ProjectDemo.dao;

import java.util.List;

import org.apache.catalina.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import com.tka.ProjectDemo.entity.Country;
import com.tka.ProjectDemo.entity.Employee;



@Repository
public class MainDao {
    @Autowired
	SessionFactory factory;
	
    public String addCountry(Country c) {
    	Session session=null;
    	Transaction tx=null;
    	String msg=null;
    	
    	try {
    		session=factory.openSession();
    		tx=session.beginTransaction();
    		session.persist(c);
    		tx.commit();
    		msg="Data Addedd Successfully...";
    	}catch(Exception e) { 
    		if(tx!=null) {
    			tx.rollback();
    		}
    		e.printStackTrace();
    	}finally {
    		if(session!=null) {
    			session.close();
    		}
    	}
    	return msg;
    } 
    
    public String updateCountry(Country c) {
    	Session session=null;
    	Transaction tx=null;
    	String msg=null;
    	try {
    		session=factory.openSession();
    		tx=session.beginTransaction();
    		
    		Country country=session.get(Country.class,c.getCid());
    		country.setCname(c.getCname());
    		session.merge(country);
    		tx.commit();
    		msg="Data is Updatated Successfully...";
    	}catch (Exception e) {
			
    		if((tx!=null)){
    			tx.rollback();
    		}
    		e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
    	return msg;
    }
    public String  deleteCountry(Country c) {
	Session session=null;
	Transaction tx=null;
	String msg=null;
	try {
		session=factory.openSession();
		 tx=session.beginTransaction();
		 
		 Country count=session.get(Country.class, c.getCid());
		 session.remove(count);
		 tx.commit();
		 msg="Data is delet Successfully...";
	}catch (Exception e) {
		if((tx!=null)) {
			tx.rollback();
		}
		e.printStackTrace();
	}finally {
		if(session!=null) {
			session.close();
		}
	}
	return msg;
	}
    
    public Country GetParticularCountry(int id) {
    	Session session=null;
    	Transaction tx=null;
    	Country c=null;
        String hqlQuery;
    	try {
    		session=factory.openSession();
    		tx=session.beginTransaction();
    	    hqlQuery="from Country where cid=:myid";
    		Query<Country>query=session.createQuery(hqlQuery,Country.class);
    		query.setParameter("myid",id);
    		c=query.uniqueResult();
    		tx.commit();
    	}catch (Exception e) {
			if((tx!=null)) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return c;
    }
    
    public List<Country>getAllRecord(){
    	Session session=null;
    	Transaction tx=null;
		List<Country> list=null;

    	try {
    		session=factory.openSession();
    		tx=session.beginTransaction();
    		String hqlQuery="from Country";
    		Query<Country>query=session.createQuery(hqlQuery,Country.class);
    		list=query.list();
    		tx.commit();
    	}catch (Exception e) {
		    if((tx!=null)) {
		    	tx.rollback();
		    }
		    e.printStackTrace();
		}finally{
			if(session!=null) {
				session.close();
			}
		}
		return list;
    }
    
    
    
 
    public String addEmployee(Employee e) {
    	Session session=null;
    	Transaction tx=null;
    	String msg=null;
    	
    	try {
    		session=factory.openSession();
    		tx=session.beginTransaction();
    		session.persist(e);
    		tx.commit();
    		msg="Data is Added Successully...";
    	}catch (Exception e1) {
			if((tx!=null)) {
				tx.rollback();
			}
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
    }
    
    public String UpdateEmploye(Employee e) {
    	Session session=null;
    	Transaction tx=null;
    	String msg=null;
    	
    	try {
    		session =factory.openSession();
    		tx=session.beginTransaction();
    		
    		Employee emp=session.get(Employee.class,e.getId());
    		emp.setName(e.getName());
    		emp.setCreatedby(e.getCreatedby());
    		emp.setCreateddtm(e.getCreateddtm());
    		emp.setDepartment(e.getDepartment());
    		emp.setPhoneno(e.getPhoneno());
    		emp.setStatus(e.getStatus());
    		emp.setUpdatedby(e.getUpdatedby());
    		emp.setCountry(e.getCountry());
    		emp.setUpdatedby(e.getUpdatedby());
    		
    		session.merge(emp);
    		
    		tx.commit();
    		
    		msg="Data is Updatated Successfully...";
    	}catch (Exception e1) {
			if((tx!=null)) {
				tx.rollback();
			}
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
    }
    
     public String deleteEmployee(Employee e) {
    	  Session session=null;
    	  Transaction tx=null;
     	  String msg=null;
     	
     	 try {
     		 session=factory.openSession();
     		 tx=session.beginTransaction();
     		 Employee emp=session.get(Employee.class,e.getId());
     		 session.remove(emp);
    		 tx.commit();
    		 msg="Data is Updatated Successfully...";
     	 }catch (Exception e1) {
			if((tx!=null)) {
				tx.rollback();
			}
     		 e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
     	  return msg;
       } 

     public Employee getParticularEmployee(int id) {
    	 Session session=null;
    	 Transaction tx=null;
    	 Employee e=null;
    	 String hqlQuery =null;
    	 
    	 try {
    		 session=factory.openSession();
    		 tx=session.beginTransaction(); 
    		 hqlQuery="from Employee where id=:myid";
    		 Query<Employee>query=session.createQuery(hqlQuery,Employee.class);
    		 query.setParameter("myid", id);
    		 e=query.uniqueResult();
    		 tx.commit();	 
    	 }catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return e;
     }
 
     public List<Employee> GetAllRecord() {
    	 Session session=null;
    	 Transaction  tx=null;
    	 List<Employee>list=null;
    	 
    	 try {
    		 session =factory.openSession();
    		 tx=session.beginTransaction();
    		 String hqlQuery="from Employee";
    		 Query<Employee>query=session.createQuery(hqlQuery,Employee.class);
    		 list=query.list();
    		 tx.commit();
    		 
    	 }catch (Exception e) {
			 if(tx!=null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
     }
    
     public List<Employee> getAllEmpByStatus(String status) {
 		Session session=null;
 		Transaction tx=null;
 		String strQuery="from Employee where status=:mystatus";
 		List<Employee> list=null;
 		
 		try {		
 			 session= factory.openSession();
 			 tx=session.beginTransaction();
 			 
 			 Query<Employee> query= session.createQuery(strQuery,Employee.class);
 			 query.setParameter("mystatus", status);
 			 
 			  list=query.list();
 			 
 			 tx.commit();
 		
 		}catch (Exception e1) {
 			if(tx!=null) {
 				tx.rollback();
 			}
 						
 			e1.printStackTrace();
 		}finally {
 			if(session!=null) {
 				session.close();
 			}
 		}
 		
 		return list;
 		
 		
 	}

public Employee checkUser(Employee emp) {
		
		Session session=null;
		Transaction tx=null;
		String strQuery="from Employee where name=:name and phoneno=:phoneno";
		Employee employee=null;
		try {		
			 session= factory.openSession();
			 tx=session.beginTransaction();
			 
			 Query<Employee> query= session.createQuery(strQuery,Employee.class);
			 
			 query.setParameter("name",emp.getName() );
			 query.setParameter("phoneno", emp.getPhoneno());
			 
			 employee= query.uniqueResult();
			 
			 tx.commit();
			 
		}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}				
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}	
		return employee;	
	}

     public User loginUser(User user) {
    	 Session session=null;
    	 Transaction tx=null;
    	 String strQuery="from User where username=:username and password=:password";
    	 User u=null;
    	 try {
    		 session= factory.openSession();
    		 tx=session.beginTransaction();
    		 Query<User>query=session.createQuery(strQuery,User.class);
    		 
    		 query.setParameter("username", user.getUsername());
    		 query.setParameter("password", user.getPassword());
    		 
    		 u=query.uniqueResult();
    		 
    		 tx.commit();
    	 }catch(Exception e) {
    		 if(tx!=null) {
    			 tx.rollback();
    		 }
    		 e.printStackTrace();
    	 }finally {
    		 if(session!=null) {
    			 session.close();
    		 }
    	 }
		return u;
     }
}

//     public List<Employee>getAllEmployee(){
//    	 Session session=null;
//    	 Transaction tx=null;
//    	 String strQuery="from Employee";
//    	 List<Employee>list=null;
//    	 try {
//    		 session= factory.openSession();
//    		 tx=session.beginTransaction();
//    		 
//    		 Query<Employee>query=session.createQuery(strQuery,Employee.class);
//    		 list=query.list();
//    		 tx.commit();
//    	 }catch (Exception e) {
//			if(tx!=null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}finally {
//			if(session!=null) {
//				session.close();
//			}
//		}
//		return list;
//     }
     
   
//     public Employee getParticularEmpById(int id) {
//    	 Session session=null;
//    	 Transaction tx=null;
//    	 Employee employee=null;
//    	 
//    	 try {
//    		 session=factory.openSession();
//    		 tx=session.beginTransaction();
//    		 employee=session.get(Employee.class,id);
//    		 tx.commit();
//    	 }catch(Exception e) {
//    		 if(tx!=null) {
//    			 tx.rollback();
//    		 }
//    		 e.printStackTrace();
//    	 }finally {
//    		 if(session!=null) {
//    			 session.close();
//    		 }
//    	 }
//		return employee;
//         }
//     
//     public Employee getEmpById(int id) {
//    	 Session session=null;
//    	 Transaction tx=null;
//    	 Employee emp=null;
//    	 String hqlquery="from Employee where id=:myid";
//    	 
//    	 try {
//    		 session=factory.openSession();
//    		 tx=session.beginTransaction();
//    		 
//    		Query<Employee>query= session.createQuery(hqlquery,Employee.class);
//    		query.setParameter("myid", id);
//    		emp= query.uniqueResult();
//    		tx.commit();
//    	 }catch (Exception e) {
//    		 if(tx!=null) {
//    			 tx.rollback();
//    		 }
//    		 e.printStackTrace();
//		}finally {
//			if(session!=null) {
//				session.close();
//			}
//		}
//		return emp;
//    	 
//     }
     
     
