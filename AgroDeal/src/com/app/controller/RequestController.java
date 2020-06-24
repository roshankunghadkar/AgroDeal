package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IRequestDao;
import com.app.pojos.Request;

@Controller
@RequestMapping("/request")
public class RequestController {
	
	@Autowired
	public IRequestDao dao;
	
	public RequestController()
	{
		
	}

	
	@GetMapping("/send-request")
	public String sendingRequest(@RequestParam int pid,@RequestParam int rid,RedirectAttributes flashamap)
	{
		flashamap.addFlashAttribute("status",dao.sendRequest(pid, rid));
		return "redirect:/";
	}
	
	
}
