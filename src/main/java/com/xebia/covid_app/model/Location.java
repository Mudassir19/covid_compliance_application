package com.xebia.covid_app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {

	@Id
	@Column(name = "ID")
	private int locationId;

	@Column(name = "PIN_CODE", unique = true)
	private int pinCode;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "PLACE")
	private String place;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "LOCATION_ID")
	private List<Area> area;

	public List<Area> getArea() {
		return area;
	}

	public void setArea(List<Area> area) {
		this.area = area;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", pinCode=" + pinCode + ", address=" + address + ", place="
				+ place + ", area=" + area + "]";
	}

}
