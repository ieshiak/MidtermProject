package com.skilldistillery.artgallery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.artgallery.data.ArtworkDAO;
import com.skilldistillery.artgallery.entities.Artwork;

@Controller
public class ArtworkController {

	@Autowired
	private ArtworkDAO artworkDAO;

//	@Value("${upload.directory}")
//	private String uploadDirectory;

	@GetMapping(path = "getArtwork.do", params = "artworkId")
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

	@RequestMapping(path = "/artwork")
	public String showArtwork(Model model) {
		List<Artwork> artworks = artworkDAO.findAll();
		model.addAttribute("artworks", artworks);
		return "artwork";
	}

	@GetMapping("/createArtwork")
	public String createArtworkForm(Model model) {
		model.addAttribute("artwork", new Artwork());
		model.addAttribute("artworkCreated", false);
		return "/createArtwork";
	}

	@PostMapping("/createArtwork")
	public String addChore(Artwork artwork, Model model) {
		try {
			Artwork newArtwork = artworkDAO.create(artwork);
			if (newArtwork != null) {
				model.addAttribute("artworkCreated", true);
				model.addAttribute("newArtwork", newArtwork);
			} else {
				model.addAttribute("artworkCreated", false);
			}
			return "/createArtwork";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "An unexpected error occurred.");
			return "error";
		}
	}

	@GetMapping("/artworkCreated")
	public String showChoreAddedPage(@ModelAttribute("artworkCreated") Boolean artworkCreated,
			@ModelAttribute("newArtwork") Artwork newArtwork, Model model) {
		model.addAttribute("artworkCreated", artworkCreated);
		model.addAttribute("newArtwork", newArtwork);
		System.out.println("artworkCreated: " + artworkCreated);
		System.out.println("newChore: " + newArtwork);
		return "/addArtworkSuccess";
	}

}
