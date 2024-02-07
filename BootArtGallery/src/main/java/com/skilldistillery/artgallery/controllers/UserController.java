package com.skilldistillery.artgallery.controllers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if (loggedInUser != null) {
			LocalDateTime loginTime = (LocalDateTime) session.getAttribute("loginTime");
			if (loginTime != null) {
				LocalDateTime now = LocalDateTime.now();
				Duration timeOnSite = Duration.between(loginTime, now);
				model.addAttribute("timeOnSite", timeOnSite);
			}

			List<Comment> comments = commentDAO.retrieveUserComments(loggedInUser.getUsername());
			model.addAttribute("comments", comments);
			List<Artwork> artworkList = new ArrayList<>();
			for (Comment comment : comments) {
				Artwork artwork = comment.getArtwork();
				if (artwork != null) {
					artworkList.add(artwork);
				}
			}
			model.addAttribute("artworkList", artworkList);

			return "account";
		} else {
			return "redirect:/login";
		}
	}

	@GetMapping("/signUp")
	public String createUserForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("userCreated", false);
		return "/signUp";
	}

	@PostMapping("/signUp")
	public String addUser(User user, Model model) {
		try {
			User newUser = userDAO.create(user);
			if (newUser != null) {
				model.addAttribute("userCreated", true);
				model.addAttribute("newUser", newUser);
			} else {
				model.addAttribute("userCreated", false);
			}
			return "/signUp";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "An unexpected error occurred.");
			return "error";
		}
	}

	@RequestMapping(path = "/admin", method = RequestMethod.GET)
	public String adminArtworkView(HttpSession session, Model model) {
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if (loggedInUser != null && loggedInUser.isAdmin()) {
			List<Artwork> artworkList = artworkDAO.findAll();
			model.addAttribute("artworkList", artworkList);
			return "/admin";
		} else {
			return "redirect:/login";
		}
	}

}