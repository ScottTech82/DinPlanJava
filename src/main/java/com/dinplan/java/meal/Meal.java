package com.dinplan.java.meal;

import javax.persistence.*;


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
	
	public Meal() {}
	

}
