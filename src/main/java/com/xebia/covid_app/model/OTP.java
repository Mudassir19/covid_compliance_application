package com.xebia.covid_app.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "otp")
public class OTP {

	@Id
	@Column(name = "ID")
	private int otpId;

	@Column(name = "OTP", nullable = false)
	private int otp;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "EXPIRY_DATE")
	private Date expiryDate;

	@OneToOne(mappedBy = "otp")
	private User user;

	public int getOtpId() {
		return otpId;
	}

	public void setOtpId(int otpId) {
		this.otpId = otpId;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "OTP [otpId=" + otpId + ", otp=" + otp + ", createdDate=" + createdDate + ", expiryDate=" + expiryDate
				+ ", user=" + user + ", getOtpId()=" + getOtpId() + ", getOtp()=" + getOtp() + ", getCreatedDate()="
				+ getCreatedDate() + ", getExpiryDate()=" + getExpiryDate() + ", getUser()=" + getUser()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
