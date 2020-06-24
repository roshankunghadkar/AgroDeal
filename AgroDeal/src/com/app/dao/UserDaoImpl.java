package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Product;
import com.app.pojos.Request;
import com.app.pojos.User;

@Repository
@Transactional
public class UserDaoImpl implements IUserDao{
	
	@Autowired // auto wiring by type
	private SessionFactory sf;

	@Override
	public User validateUser(String email, String pwd) {
		String jpql = "select u from User u where u.email = :em and u.password=:pa";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email).setParameter("pa", pwd)
				.getSingleResult();
	}

	@Override
	public String registerUser(User u) {
		sf.getCurrentSession().persist(u);//v --persistent
		return "please Login ";
	}

	@Override
	public String addToCart(int pid) {
		String jpql = "select p from Product p where p.id=:id";
		Product prod=sf.getCurrentSession().createQuery(jpql, Product.class).setParameter("id", pid).getSingleResult();
		//sf.getCurrentSession().persist(prod);		
		return "Added to cart";
	}

	@Override
	public List<Request> ShowRequests(int id) 
	{
		System.out.println("showing requests for "+id);
		String jpql="select r from Request r join fetch r.receiver where r.receiver.id=:sid";
		
		List<Request> list=sf.getCurrentSession().createQuery(jpql,Request.class).setParameter("sid", id).getResultList();
		
		System.out.println(list);
		
		return list;
	}

	@Override
	public List<Product> activeAdds(int uid) 
	{
		String jpql="select p from Product p join fetch p.seller where p.seller.id=:uid and p.status=1";
		List<Product> ads=sf.getCurrentSession().createQuery(jpql, Product.class).setParameter("uid", uid).getResultList();
		return ads;
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
	public String rejectRequest(int rid) {
		Session hs = sf.getCurrentSession();
		Request req= hs.get(Request.class, rid);
		if (req != null) {
			hs.delete(req);
		}
		return "Request Rejected";
	}

}
