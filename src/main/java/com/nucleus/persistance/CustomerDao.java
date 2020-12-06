package com.nucleus.persistance;

import java.util.List;

public interface CustomerDao {

	public Customer addCustomer(Customer customer) throws DaoException;

	public List<Customer> getAllCustomer() throws DaoException;

	public Customer deleteCustomer(String CustomerCode) throws DaoException,
			CustomerNotFoundException;

	public Customer getCustomerByCode(String CustomerCode) throws DaoException,
			CustomerNotFoundException;

	public Customer getCustomerByName(String CustomerName) throws DaoException,
			CustomerNotFoundException;

	public Customer updateCustomer(Customer customer) throws DaoException;

}
