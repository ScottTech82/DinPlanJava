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
	

}
