package org.jersey.learning.messagnger.Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Solution {
	public static void main(String[] args) {
		Profile profile = new Profile(1,"Hello","World","New World");
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(profile);
		session.getTransaction().commit();
	}
}
