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
@Table(name = "task_category")
public class TaskCategory {

	@Id
	@Column(name = "ID",nullable = false,insertable=false, updatable=false)
	private int taskCategoryId;
	
	@Column(name = "ID", nullable = false)
	private String descrition;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="TASK_ID",insertable=false, updatable=false)
	private List<Task> task;
	
	
	public int getTaskCategoryId() {
		return taskCategoryId;
	}


	public void setTaskCategoryId(int taskCategoryId) {
		this.taskCategoryId = taskCategoryId;
	}


	public String getDescrition() {
		return descrition;
	}


	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}


	public List<Task> getTask() {
		return task;
	}


	public void setTask(List<Task> task) {
		this.task = task;
	}
	
	@Override
	public String toString() {
		return "TaskCategory [taskCategoryId=" + taskCategoryId + ", descrition=" + descrition + ", task=" + task + "]";
	}




}
