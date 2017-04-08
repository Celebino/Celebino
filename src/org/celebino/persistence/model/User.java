package org.celebino.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
@NamedQuery(name = "User.getAll", query = "from User")
public class User {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "user_email" , unique = true)
	private String email;
	
	@Column(name = "user_username" ,unique = true)
	private String username;
	
	@Column(name = "user_name")
	private String name;
	
	@Column(name = "user_password")
	private String password;
	
	public User(){}
	
	public User(Long id, String email, String username, String name, String password) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.name = name;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", username=" + username + ", email=" + email  + "]";
	}
}
