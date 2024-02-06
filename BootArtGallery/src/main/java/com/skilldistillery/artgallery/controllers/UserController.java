package com.skilldistillery.artgallery.controllers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.artgallery.data.ArtworkDAO;
import com.skilldistillery.artgallery.data.CommentDAO;
import com.skilldistillery.artgallery.data.UserDAO;
import com.skilldistillery.artgallery.entities.Artwork;
import com.skilldistillery.artgallery.entities.Comment;
import com.skilldistillery.artgallery.entities.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
    private CommentDAO commentDAO;
	
	@Autowired
    private ArtworkDAO artworkDAO;
	
	
	@RequestMapping(path = "/account", method = RequestMethod.GET)
	public String accountView(HttpSession session, Model model) {
	    System.out.println("Entering accountView method");

	    LocalDateTime loginTime = (LocalDateTime) session.getAttribute("loginTime");

	    if (loginTime != null) {
	        LocalDateTime now = LocalDateTime.now();
	        Duration totalTime = Duration.between(loginTime, now);
	        session.setAttribute("timeOnSite", totalTime);
	        User loggedInUser = (User) session.getAttribute("loggedInUser");
	        System.out.println("Authenticated User: " + loggedInUser);

	        if (loggedInUser != null) {
	            model.addAttribute("loggedInUser", loggedInUser);
	            List<Comment> userComments = commentDAO.retrieveUserComments(loggedInUser.getUsername());
	            System.out.println("Retrieved Comments: " + userComments);
	            model.addAttribute("comments", userComments);
	            System.out.println("Model Attributes: " + model.asMap());
	            return "account";
	        } else {
	            return "login";
	        }
	    } else {
	        return "login";
	    }
	}
	
	@GetMapping("/createUser")
	public String createUserForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("userCreated", false);
		return "/createUser";
	}

	@PostMapping("/createUser")
	public String addUser(User user, Model model) {
		try {
			User newUser = userDAO.create(user);
			if (newUser != null) {
				model.addAttribute("userCreated", true);
				model.addAttribute("newUser", newUser);
			} else {
				model.addAttribute("userCreated", false);
			}
			return "/createUser";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "An unexpected error occurred.");
			return "error";
		}
	}

}