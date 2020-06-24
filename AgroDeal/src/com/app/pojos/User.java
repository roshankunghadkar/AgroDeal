package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Agrousers", schema="Roshan")
public class User {
	
	private Integer id;
	//@NotEmpty(message = "Please Enter the Name")
	private String  name;
	//@NotEmpty(message = "Please Enter the Password")
	//@Length(min =6,max=15,message = "Password Must between 6 to 15 Characters")
	private String password;
	//@NotEmpty(message = "Please provide your email id")
	//@Email(message = "Invalid email format")
	private String email;
	//@NotEmpty(message = "Mobile Number is required")
	//@Length(min = 10,max=10,message = "Invalid Mobile Number")
	private String mobile;
	//@NotEmpty(message = "Please Enter City")
	private String city;
	private String state;
	private String prof_pic;
	//@NotEmpty(message = "Please provide your address")
	private String address;
	//@NotEmpty(message = "Enter Pincode")
	private String pincode;
	private List<Product> sellingProducts=new ArrayList<Product>();
	private List<Order> buyer_orders=new ArrayList<Order>();
	private List<Order> seller_orders=new ArrayList<Order>();
	private List<Request> requestor=new ArrayList<Request>();
	private List<Request> receiver=new ArrayList<Request>();
	
	public User()
	{
		
	}
	
	public User(Integer id, String name, String password, String email, String mobile, String address,
			String city, String state, String prof_pic, String pincode) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.address=address;
		this.city = city;
		this.state = state;
		//this.prof_pic = prof_pic;
		this.pincode = pincode;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="UserId")
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
	@Column(length = 25,nullable = false,unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length = 10,nullable = false,unique=true)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Column(name="address",length=50)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(length = 20,nullable = false)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Column(length = 25,nullable = false)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	@Column(length = 25)
	public String getProf_pic() {
		return prof_pic;
	}

	public void setProf_pic(String prof_pic) {
		this.prof_pic = prof_pic;
	}
	@Column(length = 6,nullable = false)
	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@OneToMany(mappedBy = "buyer",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<Order> getBuyer_orders() {
		return buyer_orders;
	}

	public void setBuyer_orders(List<Order> buyer_orders) {
		this.buyer_orders = buyer_orders;
	}

	@OneToMany(mappedBy = "seller",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<Order> getSeller_orders() {
		return seller_orders;
	}

	public void setSeller_orders(List<Order> seller_orders) {
		this.seller_orders = seller_orders;
	}

	@OneToMany(mappedBy = "seller",cascade=CascadeType.ALL,orphanRemoval = true)
	public List<Product> getSellingProducts() {
		return sellingProducts;
	}
	public void setSellingProducts(List<Product> sellingProducts) {
		this.sellingProducts = sellingProducts;
	}
	
	@OneToMany(mappedBy = "sender",cascade=CascadeType.ALL,orphanRemoval = true)
	public List<Request> getRequestor() {
		return requestor;
	}

	public void setRequestor(List<Request> requestor) {
		this.requestor = requestor;
	}
	
	@OneToMany(mappedBy = "receiver",cascade=CascadeType.ALL,orphanRemoval = true)
	public List<Request> getReceiver() {
		return receiver;
	}

	public void setReceiver(List<Request> receiver) {
		this.receiver = receiver;
	}

	public void addProductList(Product p)
	{
		sellingProducts.add(p);
		p.setSeller(this);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", mobile="
				+ mobile + ", city=" + city + ", state=" + state + ", prof_pic=" + prof_pic + ", address=" + address
				+ ", pincode=" + pincode + "]";
	}
	
}
