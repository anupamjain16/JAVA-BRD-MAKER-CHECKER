package com.nucleus.persistance;


public interface UserDaoI {

	
	public void add(User user);

	public User getUserByName(String userName) throws DaoException,
			UserNotFoundException;
}
