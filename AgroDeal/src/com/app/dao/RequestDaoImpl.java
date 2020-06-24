package com.app.dao;

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
public class RequestDaoImpl implements IRequestDao{

	@Autowired
	private SessionFactory sf;
	
	
	@Override
	public String sendRequest(int pid, int rid) 
	{
		System.out.println("sending request with "+pid+" "+rid);
		String jpql="select p from Product p where p.id=:pid";
		String req="select u from User u where u.id=:rid";
		String sell="select p.seller from Product p where p.id=:pid";
		
		Product prod=sf.getCurrentSession().createQuery(jpql,Product.class).setParameter("pid", pid).getSingleResult();
		System.out.println(prod);
		
		User requestor=sf.getCurrentSession().createQuery(req,User.class).setParameter("rid", rid).getSingleResult();
		System.out.println(requestor);
		
		User receiver=sf.getCurrentSession().createQuery(sell,User.class).setParameter("pid", pid).getSingleResult();
		System.out.println(receiver);
		
		Request request=new Request();
		request.setProduct(prod);
		request.setSender(requestor);
		request.setReceiver(receiver);
		
		System.out.println(request);
		
		sf.getCurrentSession().save(request);
		
		return "Request Send Successfully";
	}


	

	
}