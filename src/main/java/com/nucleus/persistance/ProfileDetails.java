package com.nucleus.persistance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Anupam_1591112312")
public class ProfileDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int role_id_fk;

	@NotEmpty(message=" is required")
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public ProfileDetails(String roleName) {
		super();
		this.roleName = roleName;

	}

	public ProfileDetails() {
		super();

	}

}
