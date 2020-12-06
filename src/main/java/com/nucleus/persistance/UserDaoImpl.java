
package com.nucleus.persistance;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository

public class UserDaoImpl implements UserDaoI {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void add(User user) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
		user.setPassword(encoder.encode(user.getPassword()));
		em.persist(user);

	}

	@Override
	public User getUserByName(String userName) throws DaoException {
		
		User user = new User();
		String hql = "select c from User c where c.userName=:name";

		
		Query query = em.createQuery(hql);

		query.setParameter("name", userName);

	
		
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();

		if (users.size() > 0) {

			user = users.get(0);

		}
		return user;
	}
}
