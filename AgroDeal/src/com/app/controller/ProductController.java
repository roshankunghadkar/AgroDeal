package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.app.dao.IProductDao;
import com.app.pojos.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private IProductDao dao;
	
	
	public ProductController()
	{
		System.out.println("in product controller");
	}
	
	@GetMapping()
	public String ListOfProducts(Model map)
	{
		System.out.println("in default method");
		map.addAttribute("product_list",dao.listProducts());
		return "redirect:/";
	}
	
	@GetMapping("/regProduct")
	public String ShowRegForm(Product p)
	{
		System.out.println("Show register Form");
		return "/product/regProduct";
	}
	
	@PostMapping("/regProduct")
	public String ProcessRegForm(Product p,RedirectAttributes flashMap,@RequestParam int id)
	{
		System.out.println("Processing registration form");
		flashMap.addFlashAttribute("mesg",dao.addProduct(p,id));
		return "redirect:/";
	}
	
	
	@GetMapping("/details")
	public String showProdDetails(int id, HttpSession hs,RedirectAttributes flashMap)
	{
		try
		{
			Product prod=dao.showDetails(id);
			hs.setAttribute("product_details", prod);
			System.out.println(prod);
			flashMap.addFlashAttribute("status", "Product Available for you");
			return "/product/details";
		}
		catch(RuntimeException e)
		{
			flashMap.addFlashAttribute("status", "Product Not Available");
			return "/product/details";
		}
		
	}

	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam int pid, RedirectAttributes flashMap) {
		System.out.println("in del product " + pid);
		flashMap.addFlashAttribute("mesg", dao.deleteProduct(pid));
		
		return "#";
	}
	
	@GetMapping("/bargain-cart")
	public String showBargainCart(int id, HttpSession hs)
	{
		Product prod=dao.showDetails(id);
		hs.setAttribute("cart_details", prod);
		System.out.println(prod);
		return "/product/bargain-cart";
	}

	@GetMapping("/send-request")
	public String sendRequet(@RequestParam int pid,HttpSession hts)
	{
		System.out.println("sending request with "+pid);
		Product prod=dao.showDetails(pid);
		hts.setAttribute("prod_details", prod);
		return "redirect:/";
	}
	
	@GetMapping("/list")
	public String showProductList(Model map) 
	{
		System.out.println("in home/list");
		map.addAttribute("product_list",dao.listProducts());
		return "redirect:/";
	}
}
