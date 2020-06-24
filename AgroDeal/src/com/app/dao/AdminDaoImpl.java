package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Admin;
import com.app.pojos.Product;
import com.app.pojos.Request;
import com.app.pojos.User;

@Repository
@Transactional
public class AdminDaoImpl implements IAdminDao{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Admin validateAdmin(String email, String password) {
		String jpql = "select a from Admin a where a.email = :em and a.password=:pa";
		
		return sf.getCurrentSession().createQuery(jpql, Admin.class).setParameter("em", email).setParameter("pa", password)
				.getSingleResult();
	}

	@Override
	public String removeUser(int id) 
	{
		Session hs = sf.getCurrentSession();
		User usr= hs.get(User.class, id);
		if (usr != null) {
			hs.delete(usr);
		}
		return "User Deleted";
	}

	@Override
	public String removeProduct(int id) 
	{
		Session hs = sf.getCurrentSession();
		Product prod= hs.get(Product.class, id);
		if (prod != null) 
		{
			hs.delete(prod);
		}
		return "Product Removed";
	}

	@Override
	public String activateProduct(int pid) {
		System.out.println("Activating Product "+pid);
		String jpql="select p from Product p where p.id=:pid";
		Product prod=sf.getCurrentSession().createQuery(jpql, Product.class).setParameter("pid", pid).getSingleResult();
		prod.setStatus(1);
		return "Product Activated";
	}

	@Override
	public List<Product> listOfActiveProduct() {
		String jpql = "select p from Product p where p.status=1";
		return sf.getCurrentSession().createQuery(jpql, Product.class).getResultList();
	}

	@Override
	public List<Product> listOFPendingProduct() 
	{
		String jpql = "select p from Product p where p.status=0";
		return sf.getCurrentSession().createQuery(jpql, Product.class).getResultList();
	}

	@Override
	public List<User> listOfUsers() 
	{
		String jpql = "select u from User u";
		List<User> userList=sf.getCurrentSession().createQuery(jpql, User.class).getResultList();
		System.out.println("User List: "+userList);
		return userList;
	}

	@Override
	public String DeleteRequest(int id) 
	{
		Session hs = sf.getCurrentSession();
		Product prod= hs.get(Product.class, id);
		if (prod != null) 
		{
			hs.delete(prod);
		}
		return "Request Removed";
	}

}
