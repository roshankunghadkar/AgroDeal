package com.app.dao;

import java.util.List;

import com.app.pojos.Order;

public interface IOrderDao {
	
	String setOrders(int pid,int bid,int sid,int rid);
	List<Order> getOrders(int id);

}
