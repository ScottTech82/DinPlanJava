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
	

}
