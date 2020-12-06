package com.nucleus.persistance;

import java.text.ParseException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class Main {

	public static void main(String[] args) throws ParseException {
		SessionFactory factory = null;

		try {
			factory = new AnnotationConfiguration().configure()
					.buildSessionFactory();
			Session session = factory.openSession();
			session.getTransaction().begin();

			// Query query=session.createQuery("select u from UserPojo where
			// u.name:)

			ProfileDetails profile = new ProfileDetails("admin");
		

User user = new User(
					"s",
					"$2a$12$pDa5QJOX6SDA0jujMQbhs.mVp2R60Ex4OomPZA191dXcz37QstgIC",
					profile);
			session.save(user);
			session.flush();
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		finally {
			if (factory != null) {
				factory.close();
			}
		}
	}

}
