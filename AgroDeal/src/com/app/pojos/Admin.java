package com.app.pojos;

import javax.persistence.*;


@Entity
@Table(name="Admin", schema="Roshan")
public class Admin {
	
	private Integer id;
	private String  name, password, email, mobile;
	
	public Admin()
	{
		
	}
	
	public Admin(Integer id, String name, String password, String email, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length = 25,nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	@Column(length = 25,nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(length = 25,nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length = 25,nullable = false)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ",password=" + password + ", email="
				+ email + ", mobile=" + mobile + "]";
	}
	
	
	
}
