package com.nucleus.persistance;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	private EntityManager em;
	
	// --------------for adding customer details using code----------------------------
	@Override
	public Customer addCustomer(Customer customer) throws DaoException {

		customer.setRegistrationDate(new Date());

		em.persist(customer);
		return customer;
	}

	// ----------------for getting  all customer details from database-----------------
	@Override
	public List<Customer> getAllCustomer() throws DaoException {
		return em.createQuery("from Customer", Customer.class).getResultList();
	}

	
	// for deleting  customer details using code
	@Override
	public Customer deleteCustomer(String customerCode) throws DaoException, CustomerNotFoundException {
		Customer customer = getCustomerByCode(customerCode);
		if (customer != null) {
			em.remove(customer);
		}
		return null;

	}

	// for getting customer details using code
	@Override
	public Customer getCustomerByCode(String CustomerCode) throws DaoException,
			CustomerNotFoundException {
		Customer customer = new Customer();
		String hql = "select c from Customer c where c.customerCode=:code";

		Query query = em.createQuery(hql);

		query.setParameter("code", CustomerCode);

		@SuppressWarnings("unchecked")
		List<Customer> customers = query.getResultList();

		if (customers.size() > 0) {

			customer = customers.get(0);

		}
		return customer;

	}
// for updating customer details
	@Override
	public Customer updateCustomer(Customer customer) throws DaoException {

		try {

			Customer customer2 = getCustomerByCode(customer.getCustomerCode());

			customer2.setCustomerName(customer.getCustomerName());
			customer2.setContactNumber(customer.getContactNumber());
			customer2.setEmailAddress(customer.getEmailAddress());
			customer2.setState(customer.getState());
			customer2.setCustomerAddress(customer.getCustomerAddress());

			em.merge(customer2);

		} catch (CustomerNotFoundException e) {
			
			
			e.printStackTrace();
		}

		return null;
	}

	// for getting customer details using name
	@Override
	public Customer getCustomerByName(String CustomerName) throws DaoException,
			CustomerNotFoundException {

		Customer customer = new Customer();
		String hql = "select c from Customer c where c.customerName=:name";

		Query query = em.createQuery(hql);

		query.setParameter("name", CustomerName);

		@SuppressWarnings("unchecked")
		List<Customer> customers = query.getResultList();

		if (customers.size() > 0) {

			customer = customers.get(0);

		}
		return customer;

	}

}
