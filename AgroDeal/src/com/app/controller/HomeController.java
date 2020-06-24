package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.app.dao.IProductDao;


public class HomeController {
	
	@Autowired
	private IProductDao dao;
	

	/*
	@GetMapping
	public String showProductList(Model map) 
	{
		System.out.println("in home/list");
		map.addAttribute("product_list",dao.listProducts());
		return "/index";
	}
	*/
}
