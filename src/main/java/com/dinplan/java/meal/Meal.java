package com.dinplan.java.meal;

import javax.persistence.*;

import com.dinplan.java.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity(name="Meals")
@Table
public class Meal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=30, nullable=false)
	private String name;
	@Column(length=30, nullable=false)
	private String type;
	@Column(length=30, nullable=true)
	private String description;
	@Column(length=30, nullable=false)
	private String cookType;

	private int cookTemp;

	private int cookTime;
	
	@JsonBackReference
	@ManyToOne(optional=false)
	@JoinColumn(name="userId", columnDefinition="int")
	private User user;
	
	
	public Meal() {}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCookType() {
		return cookType;
	}


	public void setCookType(String cookType) {
		this.cookType = cookType;
	}


	public int getCookTemp() {
		return cookTemp;
	}


	public void setCookTemp(int cookTemp) {
		this.cookTemp = cookTemp;
	}


	public int getCookTime() {
		return cookTime;
	}


	public void setCookTime(int cookTime) {
		this.cookTime = cookTime;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}
