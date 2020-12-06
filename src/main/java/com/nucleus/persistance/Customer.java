package com.nucleus.persistance;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name = "anupam_customer589")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5348846405774012637L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int customerID;

	@NotEmpty
	@Column(nullable = false, unique = true)
	private String customerCode;
	
	@NotEmpty
	@Column(length=30)
	@Size(min=3,max=30)
	private String customerName;
	
	@NotEmpty
	@Email
	private String emailAddress;
	
	@NotEmpty
	@Size(min=3,max=100)
	@Column(length=100)
	private String customerAddress;
	
	
	@NotEmpty
	@Size(min=6,max=6)
	@Column(length=6)
	@Pattern(regexp="(^$|[0-9]{6})")
	private String customerPinCode;
	
	private String State;
	
	@NotEmpty
	@Size(min=10,max=10)
	@Column(length=10)
	@Pattern(regexp="(^$|[0-9]{10})")
	private String contactNumber;
	
	@Temporal(TemporalType.DATE)
	private Date registrationDate;
	
	
	private  String createdBy;
	
	
	
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerPinCode() {
		return customerPinCode;
	}
	public void setCustomerPinCode(String customerPinCode) {
		this.customerPinCode = customerPinCode;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerCode="
				+ customerCode + ", customerName=" + customerName
				+ ", emailAddress=" + emailAddress + ", customerAddress="
				+ customerAddress + ", customerPinCode=" + customerPinCode
				+ ", State=" + State + ", contactNumber=" + contactNumber
				+ ", registrationDate=" + registrationDate + ", createdBy="
				+ createdBy + "]";
	}
	
	
	
	public Customer(String customerCode, String customerName,
			String emailAddress, String customerAddress,
			String customerPinCode, String state, String contactNumber,
			Date registrationDate, String createdBy) {
		super();
		this.customerCode = customerCode;
		this.customerName = customerName;
		this.emailAddress = emailAddress;
		this.customerAddress = customerAddress;
		this.customerPinCode = customerPinCode;
		State = state;
		this.contactNumber = contactNumber;
		this.registrationDate = new Date();
		this.createdBy = createdBy;
	}
	public Customer() {
		super();
	}

	

}
