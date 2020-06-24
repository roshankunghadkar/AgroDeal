package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Product;
import com.app.pojos.Request;
import com.app.pojos.User;

@Repository
@Transactional
public class ProductdaoImpl implements IProductDao{
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public String addProduct(Product p,int id)
	{
		String jpql="select u from User u where u.id=:id";
		User u=sf.getCurrentSession().createQuery(jpql,User.class).setParameter("id",id).getSingleResult();
		u.addProductList(p);
		sf.getCurrentSession().save(p);
		return "Product Added Successfully with Id: "+p.getId();
	}
	@Override
	public String deleteProduct(int id)
	{
		return null;
	}
	@Override
	public List<Product> listProducts()
	{
		System.out.println("in list Products");
		String jpql="SELECT p FROM Product p where p.status=1";
		
		return sf.getCurrentSession().createQuery(jpql,Product.class).getResultList();
	}
	
	@Override
	public Product showDetails(int pid) {
		System.out.println("showing product details with id "+pid);
		String jpql="select p from Product p where p.id=:pid";
		return sf.getCurrentSession().createQuery(jpql, Product.class).setParameter("pid", pid).getSingleResult();
	}
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
		request.setReceiver(receiver);
		request.setSender(requestor);
		
		sf.getCurrentSession().save(request);
		
		return "Request Send Succesfully";
	}
}
