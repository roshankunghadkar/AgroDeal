package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IAdminDao;
import com.app.pojos.Admin;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IAdminDao dao;
	
	public AdminController()
	{
		System.out.println("In Admin controller");
	}
	
	@GetMapping("/login")
	public String showLoginform()
	{
		System.out.println("Showing Admin Login Form");
		return "/admin/login";
	}
	
	@PostMapping("/login") 
	public String processLoginForm(@RequestParam String em,
			@RequestParam String pass, Model map,
			RedirectAttributes flashMap, HttpSession hs) {
		System.out.println("in process login form");
		try {
			Admin a = dao.validateAdmin(em, pass);
			
			hs.setAttribute("admin_details", a);
			flashMap.addFlashAttribute("mesg", "Login Successful");
			return "/admin/dashboard";
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
			map.addAttribute("mesg", "Invalid Login");
			return "/admin/login";
		}

	}
	
	@GetMapping("/pendingProducts")
	public String showPendingList(Model map) 
	{
			System.out.println("showing products list");
			map.addAttribute("product_list", dao.listOFPendingProduct());
			return "/admin/PendingProducts";
	}
	
	@GetMapping("/activeProducts")
	public String showActiveList(Model map) 
	{
			System.out.println("showing products list");
			map.addAttribute("product_list", dao.listOfActiveProduct());
			return "/admin/ActiveProducts";
	}
	
	@GetMapping("/listOfUsers")
	public String showVendorList(Model map) 
	{
			System.out.println("showing products list");
			map.addAttribute("user_list",dao.listOfUsers());
			return "/admin/RegisteredUsers";
	}

	@GetMapping("/update")
	public String activateProduct(@RequestParam int id,RedirectAttributes flashMap)
	{
		try
		{
				System.out.println("updating product with id "+id);
				flashMap.addFlashAttribute("status",dao.activateProduct(id));
				return "redirect:/admin/pendingProducts";
		}
		catch(RuntimeException e)
		{
			System.out.println("error while Activating Product");
			flashMap.addFlashAttribute("status", "error while Activating Product");
			return "redirect:/admin/pendingProducts";
		}
	}
	
	
	@GetMapping("/removeProduct")
	public String removeProduct(@RequestParam int pid,RedirectAttributes flashmap)
	{
		flashmap.addFlashAttribute("removeStatus",dao.removeProduct(pid));
		return "redirect:/admin/activeProducts";
	}
	
	@GetMapping("/removeUser")
	public String removeUser(@RequestParam int uid,RedirectAttributes flashmap)
	{
		flashmap.addFlashAttribute("removeStatus",dao.removeUser(uid));
		return "redirect:/admin/listOfUsers";
	}
	
	
	@GetMapping("delete")
	public String DeleteRequest(@RequestParam int id,RedirectAttributes flashmap)
	{
		
		flashmap.addFlashAttribute("status",dao.DeleteRequest(id));
		return "redirect:/admin/pendingProducts";
	}
	
	@GetMapping("/logout")
	public String userLogout(HttpSession hs,Model map,HttpServletRequest request,HttpServletResponse resp) {
		System.out.println("in admin logout");
		map.addAttribute("admin_dtls",hs.getAttribute("admin_details"));
		resp.setHeader("refresh", "5;url="+request.getContextPath());
		hs.invalidate();
		return "redirect:/";
	}
	
}
