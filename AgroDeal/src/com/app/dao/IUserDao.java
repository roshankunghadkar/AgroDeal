package com.app.dao;

import java.util.List;

import com.app.pojos.Product;
import com.app.pojos.Request;
import com.app.pojos.User;


public interface IUserDao {
	User validateUser(String email, String pwd);
	String registerUser(User u);
	String addToCart(int id);
	String removeProduct(int id);
	List<Request> ShowRequests(int id);
	List<Product> activeAdds(int uid);
	String rejectRequest(int rid);
}
