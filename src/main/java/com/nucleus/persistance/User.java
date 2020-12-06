package com.nucleus.persistance;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Anupam_15911123")
public class User implements Serializable {
	
	private static final long serialVersionUID = 8025908100563712359L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userid;

	@NotEmpty(message=" is required")
	private String userName;

	@NotEmpty(message=" is required")
	private String password;

	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "role_id_fk")
	private ProfileDetails profile;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ProfileDetails getProfile() {
		
		return profile;
	}

	public void setProfile(ProfileDetails profile) {
		this.profile = profile;
	}
	

	public User(String userName, String password, ProfileDetails profile) {
		super();
		this.userName = userName;
		this.password = password;
		this.profile = profile;
	}

	public User() {
		super();

	}

}
