package com.skilldistillery.artgallery.controllers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.artgallery.data.ArtworkDAO;
import com.skilldistillery.artgallery.data.CommentDAO;
import com.skilldistillery.artgallery.data.UserDAO;
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

}