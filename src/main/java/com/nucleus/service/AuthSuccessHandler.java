package com.nucleus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.nucleus.persistance.DaoException;
import com.nucleus.persistance.User;
import com.nucleus.persistance.UserNotFoundException;

public class AuthSuccessHandler implements UserDetailsService {

	@Autowired
	private ServiceDao serviceDao;

	@Override
	public UserDetails loadUserByUsername(String userName) {

		UserDetails userDetails = null;

		try {
			User user = serviceDao.getUserByName(userName);


			userDetails = new org.springframework.security.core.userdetails.User(
					user.getUserName(), user.getPassword(),
					AuthorityUtils.createAuthorityList(user.getProfile().getRoleName()));
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userDetails;

	}
}
