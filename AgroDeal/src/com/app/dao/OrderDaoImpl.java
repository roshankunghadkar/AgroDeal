package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Order;
import com.app.pojos.Product;
import com.app.pojos.Request;
import com.app.pojos.User;
@Repository
@Transactional
public class OrderDaoImpl implements IOrderDao{

	@Autowired 
	private SessionFactory sf;
	
	
	@Override
	public String setOrders(int pid,int bid, int sid,int rid) 
	{
		String jpql1="select p from Product p where p.id=:pid";
		String jpql2="select b from User b where b.id=:bid";
		String jpql3="select s from User s where s.id=:sid";
		//String jpql4="select r from Request r where r.requestid=:rid";
		
		Product product=sf.getCurrentSession().createQuery(jpql1,Product.class).setParameter("pid", pid).getSingleResult();
		User buyer=sf.getCurrentSession().createQuery(jpql2,User.class).setParameter("bid", bid).getSingleResult();
		User seller=sf.getCurrentSession().createQuery(jpql3,User.class).setParameter("sid", sid).getSingleResult();
		
		Order order=new Order();
		order.setBuyingProducts(product);
		order.setBuyer(buyer);
		order.setSeller(seller);
		sf.getCurrentSession().save(order);
		
		Session hs = sf.getCurrentSession();
		Request req= hs.get(Request.class, rid);
		if (req != null) {
			hs.delete(req);
		}
		return "Request Accepted";
	}

	@Override
	public List<Order> getOrders(int id) 
	{
		String jpql="select o from Order o join fetch o.seller where o.seller.id=:id";

		return sf.getCurrentSession().createQuery(jpql,Order.class).setParameter("id", id).getResultList();
	}

}
