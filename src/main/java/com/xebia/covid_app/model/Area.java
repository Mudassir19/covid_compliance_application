package com.xebia.covid_app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "areas")
public class Area {

	@Id
	@Column(name = "ID")
	private int areaId;

	@Column(name = "PLACE")
	private int place;

	// Location one to many
	@ManyToOne
	private Location location;

	// One Area is having multiple task
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "TASK_ID")
	private List<Task> task;

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "Area [areaId=" + areaId + ", place=" + place + ", location=" + location + ", task=" + task + "]";
	}

}
