package com.nucleus.service;

import java.util.List;

import com.nucleus.persistance.Customer;
import com.nucleus.persistance.CustomerNotFoundException;
import com.nucleus.persistance.DaoException;
import com.nucleus.persistance.User;
import com.nucleus.persistance.UserNotFoundException;

public interface ServiceDao {
	public Customer addCustomer(Customer customer)throws DaoException;
	public List<Customer> getAllCustomer()throws DaoException;
	public Customer deleteCustomer(String CustomerCode)throws DaoException, CustomerNotFoundException;
	public Customer getCustomerByCode(String CustomerCode)throws DaoException, CustomerNotFoundException;
	public Customer updateCustomer(Customer customer)throws DaoException;
	
	public void add(User user);
	
	public User getUserByName(String userName)throws DaoException,UserNotFoundException;
	public Customer getCustomerByName(String CustomerName)throws DaoException, CustomerNotFoundException;
}
