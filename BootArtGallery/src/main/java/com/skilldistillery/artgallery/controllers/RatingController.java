package com.skilldistillery.artgallery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.skilldistillery.artgallery.data.RatingDAO;
import com.skilldistillery.artgallery.entities.Rating;

@Controller
public class RatingController {

	@Autowired
    private RatingDAO ratingDAO;

	@GetMapping("createRating.do")
	public String createRating(Model model) {
		model.addAttribute("rating", new Rating());
		model.addAttribute("ratingCreated", false);
		return "createRating.do";
	}

	@PostMapping("createRating.do")
	public String addRating(Rating rating, Model model) {
		try {
			Rating newRating = ratingDAO.create(rating);
			if (newRating != null) {
				model.addAttribute("ratingCreated", true);
				model.addAttribute("newRating", newRating);
			} else {
				model.addAttribute("ratingCreated", false);
			}
			return "createRating.do";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "An unexpected error occurred.");
			return "error";
		}
	}
}

