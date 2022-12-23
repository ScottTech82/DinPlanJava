package com.dinplan.java.user;

import javax.persistence.*;



@Entity(name="Users")
@Table(uniqueConstraints=@UniqueConstraint(name="UIDX_Username", columnNames= {"username"}))
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=30, nullable=false)
	private String username;
	@Column(length=30, nullable=true)
	private String favorite;

	
	
	public User() {}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFavorite() {
		return favorite;
	}

	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	
	
	
	
}
