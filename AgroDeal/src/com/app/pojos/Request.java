package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name="Requests",schema="Roshan")
public class Request {
	private int requestId;
	private int quantity;
	private Product product;
	private User sender;
	private User receiver;
	
	
	public Request()
	{
		
	}
	
	public Request(int requestId, int quantity) {
		super();
		this.requestId = requestId;
		this.quantity = quantity;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="requestId")	
	public int getRequestId() {
		return requestId;
	}


	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	@Column(name="Quantity")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@ManyToOne
	@JoinColumn(name="ProductId")
	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	@ManyToOne
	@JoinColumn(name="BuyerId")
	public User getSender() {
		return sender;
	}


	public void setSender(User sender) {
		this.sender = sender;
	}

	
	@ManyToOne
	@JoinColumn(name="SellerId")
	public User getReceiver() {
		return receiver;
	}


	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", quantity=" + quantity + "]";
	}

}
