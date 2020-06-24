package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IOrderDao;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private IOrderDao dao;
	
	public OrderController()
	{
		
	}

	
	@GetMapping("/setorder")
	public String setOrder(@RequestParam int pid,@RequestParam int bid,@RequestParam int sid,@RequestParam int rid,RedirectAttributes flashmap)
	{
		flashmap.addFlashAttribute("orderStatus",dao.setOrders(pid, bid, sid, rid));
		return "redirect:/";
	}
	
	@GetMapping("/getorders")
	public String getOrders(@RequestParam int id,HttpSession hs)
	{
		hs.setAttribute("Order_Details",dao.getOrders(id));
		return "/user/Orders";
	}
}
