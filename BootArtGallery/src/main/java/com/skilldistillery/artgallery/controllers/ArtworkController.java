package com.skilldistillery.artgallery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.artgallery.data.ArtworkDAO;
import com.skilldistillery.artgallery.entities.Artwork;

@Controller
public class ArtworkController {

	@Autowired
	private ArtworkDAO artworkDAO;

	@GetMapping(path = "getArtwork.do", params = "artworkId")
	public String getArtworkById(@RequestParam("artworkId") int artworkId, Model model) {
		System.out.println("getArtworkById method called with Artwork ID: " + artworkId);
		Artwork artwork = artworkDAO.findById(artworkId);
		if (artwork != null) {
			model.addAttribute("artwork", artwork);
			return "/artworkById";
		} else {
			System.out.println("Artwork not found with ID: " + artworkId);
			return "error";
		}
	}
	
	@GetMapping(path = "searchArtwork.do", params = "keyword")
	public String searchArtworkByKeyword(@RequestParam("keyword") String keyword, Model model) {
	    System.out.println("searchArtworkByKeyword method called with Keyword: " + keyword);
	    List<Artwork> artworks = artworkDAO.findByKeyword(keyword);
	    if (!artworks.isEmpty()) {
	        model.addAttribute("artworks", artworks);
	        return "/searchResults";
	    } else {
	        System.out.println("No artwork found with keyword: " + keyword);
	        model.addAttribute("error", "No artwork found with keyword: " + keyword);
	        return "error";
	    }
	}


	@GetMapping("/artwork")
	public String showArtworks(Model model) {
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
	public String addArtwork(Artwork artwork, Model model) {
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
	public String showArtworkAddedPage(@ModelAttribute("artworkCreated") Boolean artworkCreated,
			@ModelAttribute("newArtwork") Artwork newArtwork, Model model) {
		model.addAttribute("artworkCreated", artworkCreated);
		model.addAttribute("newArtwork", newArtwork);
		System.out.println("artworkCreated: " + artworkCreated);
		System.out.println("newArtwork: " + newArtwork);
		return "/addArtworkSuccess";
	}

	@GetMapping("/editArtwork/{id}")
	public String editArtworkForm(@PathVariable(name = "id") int id, Model model) {
		try {
			Artwork artwork = artworkDAO.findById(id);

			if (artwork != null) {
				model.addAttribute("editedArtwork", artwork);

				System.out.println("Artwork Title: " + artwork.getTitle());

				return "/editArtwork";
			} else {
				System.out.println("Artwork not found with ID: " + id);
				model.addAttribute("error", "Artwork not found.");
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occurred in editArtworkForm: " + e.getMessage());
			return "error";
		}
	}
	
	@GetMapping("/deleteArtwork")
	public String deleteArtworkForm(@RequestParam(name = "id") int id, Model model) {
		try {
			Artwork artworkToDelete = artworkDAO.findById(id);
			System.err.println("*****************" + artworkToDelete);
			if (artworkToDelete != null) {
				model.addAttribute("deleteArtwork", artworkToDelete);

				System.out.println("Artwork Title: " + artworkToDelete.getTitle());

				return "/deleteArtwork";
			} else {
				System.out.println("Artwork not found with ID: " + id);
				model.addAttribute("error", "Artwork not found.");
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occurred in deleteArtworkForm: " + e.getMessage());
			model.addAttribute("error", "Exception occurred in deleteArtworkForm: " + e.getMessage());
			return "error";
		}
	}
		
}

