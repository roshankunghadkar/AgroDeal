package com.app.pojos;

import javax.persistence.*;


@Entity
@Table(name="Orders",schema="Roshan")
public class Order {
	private int orderId;
	private Product buyingProducts;
	private User buyer;
	private User seller;
	
	public Order()
	
	{
		
	}
	
	public Order(int orderId) {
		super();
		this.orderId = orderId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="orderId")
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	
	@ManyToOne
	@JoinColumn(name="buyerId") 
	public User getBuyer() {
		return buyer;
	}
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	
	@ManyToOne
	@JoinColumn(name="sellerId") 
	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", product=" + buyingProducts + ", buyer=" + buyer + "]";
	}
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="productId")
	public Product getBuyingProducts() {
		return buyingProducts;
	}

	public void setBuyingProducts(Product buyingProducts) {
		this.buyingProducts = buyingProducts;
	}
	
	

}
