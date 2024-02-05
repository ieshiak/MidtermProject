package com.skilldistillery.artgallery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.artgallery.data.ArtworkDAO;
import com.skilldistillery.artgallery.entities.Artwork;

@Controller
public class ArtworkController {

	@Autowired
	private ArtworkDAO artworkDAO;

	@Value("${upload.directory}")
	private String uploadDirectory;

	@GetMapping(path = "/artwork", params = "artworkId")
	public String getArtworkById(@RequestParam("artworkId") int artworkId, Model model) {
		System.out.println("getArtworkById method called with Artwork ID: " + artworkId);

		Artwork artwork = artworkDAO.findById(artworkId);

		if (artwork != null) {
			model.addAttribute("artwork", artwork);
			return "/artworkById";
		} else {
			System.out.println("Artwork not found with ID: " + artworkId);
			return "artworkNotFound";
		}
	}
}
