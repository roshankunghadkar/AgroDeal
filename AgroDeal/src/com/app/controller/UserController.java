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
import com.app.dao.IUserDao;
import com.app.pojos.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired // auto wiring by type
	private IUserDao dao;

	public UserController() {
		System.out.println("in user controller constr");
	}

	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/user/login";
	}

	@PostMapping("/login") 
	public String processLoginForm(@RequestParam String em,
			@RequestParam String pass, Model map,
			RedirectAttributes flashMap, HttpSession hs) 
	{
		System.out.println("in process login form");
		try {
			User u = dao.validateUser(em, pass);
			
			hs.setAttribute("user_details", u);
			flashMap.addFlashAttribute("mesg", "Login Successful");
			return "redirect:/";
		} catch (RuntimeException e) 
		{
			System.out.println("err in controller " + e);
			map.addAttribute("mesg", "Invalid Login");
			return "/user/login";
		}

	}
	
	@GetMapping("/register")
	public String showRegForm(User v) {
		System.out.println("in show reg form");
		return "/user/register";

	}

	@PostMapping("/register")
	public String processRegForm( User u, RedirectAttributes flashMap) {
		System.out.println("in process reg form " + u);// transient
		flashMap.addFlashAttribute("mesg", dao.registerUser(u));
		return "redirect:/user/login";
	}
	
	@GetMapping("/profile")
	public String showProfile()
	{
		System.out.println("showing profile");
		return "/user/profile";
	}
	
	@GetMapping("/logout")
	public String userLogout(HttpSession hs,Model map,HttpServletRequest request,HttpServletResponse resp) {
		System.out.println("in user logout");
		map.addAttribute("u_dtls",hs.getAttribute("user_detalis"));
		resp.setHeader("refresh", "5;url="+request.getContextPath());
		hs.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/cart")
	public String addToCart(int id, HttpSession hs)
	{
		
		return "/user/cart";
	}
	
	@GetMapping("/product-requests")
	public String showRequests(@RequestParam int id,HttpSession hs)
	{
		try
		{
				hs.setAttribute("RequestList", dao.ShowRequests(id));
				return "/user/requests";
			
		}
		catch(Exception e)
		{
			return "/user/login";
		}
	}
	
	@GetMapping("/activeAds")
	public String getAdds(@RequestParam int uid,Model map)
	{
		map.addAttribute("product_list", dao.activeAdds(uid));
		return "/user/ActiveAds";
	}
	
	@GetMapping("/removeProduct")
	public String removeProduct(@RequestParam int pid,RedirectAttributes flashmap)
	{
		flashmap.addFlashAttribute("removeStatus",dao.removeProduct(pid));
		return "redirect:/user/activeAds";
	}
	
	@GetMapping("/reject-request")
	public String rejectRequest(@RequestParam int rid,RedirectAttributes flashmap)
	{
		flashmap.addFlashAttribute("requestStatus",dao.rejectRequest(rid));
		return "/user/requests";
	}
}
