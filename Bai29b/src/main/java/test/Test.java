package test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Cat;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
	    Session session = factory.getCurrentSession();
	      
		org.hibernate.Transaction tr = session.beginTransaction();
		Cat cat1 = new Cat();
		cat1.setName("Tom");
		
		session.save(cat1);
		
		
		tr.commit();
		session.close();
		
	}
}
