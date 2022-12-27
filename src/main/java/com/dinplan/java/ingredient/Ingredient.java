package com.dinplan.java.ingredient;

import javax.persistence.*;

@Entity(name="Ingredients")
@Table(uniqueConstraints=@UniqueConstraint(name="UIDX_name", columnNames="{name}"))
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=30, nullable=false)
	private String name;
	
	@Column(length=30, nullable=true)
	private String amount;
	
	@Column(length=200, nullable=true)
	private String notes;
	
	
	public Ingredient() {}


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


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	

}
