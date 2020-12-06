package com.nucleus.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nucleus.persistance.Customer;
import com.nucleus.persistance.CustomerDao;
import com.nucleus.persistance.CustomerNotFoundException;
import com.nucleus.persistance.DaoException;
import com.nucleus.persistance.User;
import com.nucleus.persistance.UserDaoI;
import com.nucleus.persistance.UserNotFoundException;

@Service
public class ServiceDaoImpl implements ServiceDao {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private UserDaoI userDao;

	@Override
	@Transactional
	public Customer addCustomer(Customer customer) throws DaoException {

		return customerDao.addCustomer(customer);
	}

	@Override
	public List<Customer> getAllCustomer() throws DaoException {

		return customerDao.getAllCustomer();
	}

	@Override
	@Transactional
	public Customer deleteCustomer(String CustomerCode) throws DaoException,
			CustomerNotFoundException {

		return customerDao.deleteCustomer(CustomerCode);
	}

	@Override
	public Customer getCustomerByCode(String CustomerCode) throws DaoException,
			CustomerNotFoundException {

		return customerDao.getCustomerByCode(CustomerCode);
	}

	@Override
	@Transactional
	public Customer updateCustomer(Customer customer) throws DaoException {

		return customerDao.updateCustomer(customer);
	}

	@Override
	@Transactional
	public void add(User user) {
		userDao.add(user);

	}

	@Override
	public User getUserByName(String userName) throws DaoException,
			UserNotFoundException {

		return userDao.getUserByName(userName);
	}

	@Override
	public Customer getCustomerByName(String CustomerName) throws DaoException,
			CustomerNotFoundException {
		
		return customerDao.getCustomerByName(CustomerName);
	}

	

}
