package com.app.dao;

import java.util.List;

import com.app.pojos.Admin;
import com.app.pojos.Product;
import com.app.pojos.User;

public interface IAdminDao {
	
	Admin validateAdmin(String email, String password);
	String removeUser(int id);
	String removeProduct(int id);
	String activateProduct(int id);
	List<Product> listOfActiveProduct();
	List<Product> listOFPendingProduct();
	List<User> listOfUsers();
	String DeleteRequest(int id);
}
