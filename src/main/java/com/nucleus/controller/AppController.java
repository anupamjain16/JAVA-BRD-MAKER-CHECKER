/* @Author Anupam Jain
 * Created Date : 11 AUGUST,2018
 * LAST MODIFIED DATE: 19 AUGUST,2018
 */

package com.nucleus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nucleus.persistance.Customer;
import com.nucleus.persistance.CustomerNotFoundException;
import com.nucleus.persistance.DaoException;
import com.nucleus.persistance.User;
import com.nucleus.service.ServiceDao;

@Controller
@RequestMapping
public class AppController {

	static String viewpath;

	@Autowired
	private ServiceDao dao;

	@Value("${state}")
	private String State;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView success(Model model, Authentication authentication,
			HttpServletRequest httpServlet) {

		authentication.getPrincipal();

		for (GrantedAuthority a : authentication.getAuthorities()) {

			if (a.getAuthority().equals("admin")) {
				return new ModelAndView("redirect:" + "/userform");
			} else {
				return new ModelAndView("redirect:" + "/menu");
			}
		}
		return null;

	}

	// -------------------main menu-------------------------------------

	@RequestMapping("/menu")
	public String menu(Model theModal) {

		Customer customer = new Customer();

		String[] numArray = State.split(",");

		theModal.addAttribute("numArray", numArray);

		theModal.addAttribute("Customer", customer);

		List<Customer> customers = null;

		try {

			customers = dao.getAllCustomer();
			theModal.addAttribute("customer", customers);

		} catch (DaoException e) {

			log.info(e.getMessage());
			log.fatal(e.getMessage());
		}

		return "menu";
	}

	// ------------------------new User-------------------------------------

	@RequestMapping("/userform")
	public String showform(Model theModal) {

		User user = new User();
		theModal.addAttribute("User", user);
		return "UserForm";
	}

	@RequestMapping("/processform")
	public String processform(@Valid @ModelAttribute("User") User user,
			BindingResult theBindingResult, Model theModal) {

		if (theBindingResult.hasErrors()) {

			return "UserForm";
		}

		else {

			dao.add(user);

			return "success";
		}
	}

	// ----------------new Customer signup--------------------------------------

	@RequestMapping("/new")
	public String signupform(Model theModal) {

		Customer customer = new Customer();

		String[] numArray = State.split(",");

		theModal.addAttribute("numArray", numArray);

		theModal.addAttribute("Customer", customer);

		return "CustomerForm";
	}

	@RequestMapping("/customerprocessform")
	public String customerprocessform(
			@Valid @ModelAttribute("Customer") Customer customer,
			BindingResult theBindingResult, Model theModal)
			throws CustomerNotFoundException {

		if (theBindingResult.hasErrors()) {

			String[] numArray = State.split(",");
			theModal.addAttribute("numArray", numArray);

			return "menu";

		} else {

			try {

				Customer customer2 = dao.getCustomerByCode(customer
						.getCustomerCode());

				if (customer2.getCustomerCode() != null) {
					return "customeravailabel";
				} else {

					Authentication auth = SecurityContextHolder.getContext()
							.getAuthentication();
					String name = auth.getName();
					customer.setCreatedBy(name);
					dao.addCustomer(customer);
				}

			} catch (DaoException e) {
				log.info(e.getMessage());
				log.fatal(e.getMessage());
			}

			String[] numArray = State.split(",");

			theModal.addAttribute("numArray", numArray);

			return "menu";
		}

	}

	// ----------------controller for delete
	// customer----------------------------

	@RequestMapping("/delete")
	public String delete(Model theModal) {

		Customer customer = new Customer();
		theModal.addAttribute("Customer", customer);

		return "deleteCustomer";
	}

	@RequestMapping("/deletecustomer")
	public String processform(@ModelAttribute("Customer") Customer customer)
			throws CustomerNotFoundException, DaoException {

		Customer customer2 = dao.getCustomerByCode(customer.getCustomerCode());

		if (customer2.getCustomerName() != null) {
			try {
				dao.deleteCustomer(customer.getCustomerCode());
			} catch (DaoException e) {

				log.info(e.getMessage());
				log.fatal(e.getMessage());

			} catch (CustomerNotFoundException e) {

				log.info(e.getMessage());
				log.fatal(e.getMessage());
			}

			return "menu";
		} else {
			return "error";
		}
	}

	// ----------------------------View----------------------------------

	@RequestMapping("/view")
	public String view(Model theModal) {

		return "view";
	}

	@RequestMapping("/viewall")
	public String viewAll(Model theModal) {

		List<Customer> customers = null;

		try {
			customers = dao.getAllCustomer();

			theModal.addAttribute("customer", customers);

		} catch (DaoException e) {

			log.info(e.getMessage());
			log.fatal(e.getMessage());
		}
		return "viewallcustomer";
	}

	@RequestMapping("/viewsingle")
	public String viewsingle(Model theModal) {

		Customer customer = new Customer();
		theModal.addAttribute("Customer", customer);

		return "showSingleCustomer";
	}

	@RequestMapping("/showsinglecustomer")
	public String showsinglecustomer(
			@ModelAttribute("Customer") Customer customer2, Model theModal)
			throws DaoException, CustomerNotFoundException {

		Customer customer3 = dao.getCustomerByCode(customer2.getCustomerCode());

		if (customer3.getCustomerName() != null) {

			theModal.addAttribute("customer", customer3);

			return "viewsinglecustomer";

		}

		return "error";
	}

	// ---------------------------- Update Customer------------------------

	@RequestMapping("/update")
	public String update(Model theModal) {

		Customer customer = new Customer();
		theModal.addAttribute("Customer", customer);

		return "updateCustomer";
	}

	@RequestMapping("/updatecustomer")
	public String showsinglecustomeghjr(

	@ModelAttribute("Customer") Customer customer, Model theModal)
			throws DaoException, CustomerNotFoundException {

		Customer customer2 = dao.getCustomerByCode(customer.getCustomerCode());

		if (customer2.getCustomerName() != null) {
			theModal.addAttribute("Customer", customer2);

			String[] numArray = State.split(",");

			theModal.addAttribute("numArray", numArray);

			return "updateform";
		} else {

			return "error";
		}
	}

	@RequestMapping("/updateformdetails")
	public String updatedetails(@ModelAttribute("Customer") Customer customer) {

		System.out.println(customer);
		try {
			dao.updateCustomer(customer);
		} catch (DaoException e) {
			log.info(e.getMessage());
			log.fatal(e.getMessage());
		}
		return "menu";
	}

	// ------------LOGIN MAPPING-----------------------------------

	@RequestMapping("/login")
	public String login() {

		return "login";

	}

	private static final Logger log = Logger.getLogger(AppController.class);

}
