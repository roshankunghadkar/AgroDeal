package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Productss", schema="Roshan")
public class Product {
	private Integer id;
	//@NotEmpty(message = "Please Enter Product Price")
	private double prodPrice;
	//@NotEmpty(message = "Please Enter Product Name")
	private String  prodName;
	//@NotEmpty(message = "Please Give Description")
	//@Length(min =10,max=50,message = "Description Must between 10 to 50 Characters")
	private String prodDesc;
	private String prodImg;
	//@NotEmpty(message = "Please Enter city")
	private String city;
	
	private int status=0;
	private User seller;
	private Order order;
	private List<Request> requestList=new ArrayList<Request>();
	
	public Product()
	{
		
	}
	
	public Product(Integer id, String prodName, double prodPrice, String prodDesc,String city, String prodImg) {
		super();
		this.id = id;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodDesc = prodDesc;
		this.city=city;
		this.prodImg = prodImg;
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="productId")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(length = 25,nullable = false)
	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@Column(length =10,nullable = false)
	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	@Column(length = 100)
	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	
	@Column(length =20,nullable = false)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(length = 25,nullable = false)
	public String getProdImg() {
		return prodImg;
	}

	public void setProdImg(String prodImg) {
		this.prodImg = prodImg;
	}
	
	@Column()
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@ManyToOne
	@JoinColumn(name="sellerId") 
	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}
	
	@OneToOne(mappedBy = "buyingProducts",cascade=CascadeType.ALL,orphanRemoval = true)
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@OneToMany(mappedBy = "product",cascade=CascadeType.ALL,orphanRemoval = true)
	public List<Request> getRequest() {
		return requestList;
	}

	public void setRequest(List<Request> request) {
		this.requestList = request;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", prodPrice=" + prodPrice + ", prodName=" + prodName + ", prodDesc=" + prodDesc
				+ ", prodImg=" + prodImg + ", city=" + city + ", status=" + status + "]";
	}
	
}
