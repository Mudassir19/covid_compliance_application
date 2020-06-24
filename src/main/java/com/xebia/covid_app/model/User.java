package com.xebia.covid_app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "ID")
	private int userId;

	@Column(name = "Email_Id", unique = true, nullable = false)
	private String emailId;

	@Column(name = "ACTIVE")
	private boolean isActive;

	@Column(name = "MOBILE_NUMBER")
	private boolean mobNumer;

	@OneToOne
	@JoinColumn(name = "OTP_ID")
	private OTP otp;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "USER_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID") })
	List<Role> roles = new ArrayList<Role>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isMobNumer() {
		return mobNumer;
	}

	public void setMobNumer(boolean mobNumer) {
		this.mobNumer = mobNumer;
	}

	public OTP getOtp() {
		return otp;
	}

	public void setOtp(OTP otp) {
		this.otp = otp;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", emailId=" + emailId + ", isActive=" + isActive + ", mobNumer=" + mobNumer
				+ ", otp=" + otp + ", roles=" + roles + ", getUserId()=" + getUserId() + ", getEmailId()="
				+ getEmailId() + ", isActive()=" + isActive() + ", isMobNumer()=" + isMobNumer() + ", getOtp()="
				+ getOtp() + ", getRoles()=" + getRoles() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
