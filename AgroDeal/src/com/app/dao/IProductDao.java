package com.app.dao;

import java.util.List;

import com.app.pojos.Product;

public interface IProductDao {
	
	String addProduct(Product p,int id);
	String deleteProduct(int id);
	List<Product> listProducts();
	Product showDetails(int id);
	String sendRequest(int pid,int rid);
}
