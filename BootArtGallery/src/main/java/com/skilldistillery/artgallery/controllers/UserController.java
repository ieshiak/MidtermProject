package com.skilldistillery.artgallery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.skilldistillery.artgallery.data.UserDAO;
import com.skilldistillery.artgallery.entities.User;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDAO;
	
	@GetMapping("/")
	public String home(Model model) {
		User u = userDAO.authenticateUser("jane", "jane");
		model.addAttribute("testUser", u);
		return "home";
		
	}
	
	
	

}
