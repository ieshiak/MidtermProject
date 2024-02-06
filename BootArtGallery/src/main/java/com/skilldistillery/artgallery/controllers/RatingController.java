package com.skilldistillery.artgallery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.skilldistillery.artgallery.data.RatingDAO;

@Controller
public class RatingController {

	@Autowired
    private RatingDAO ratingDAO;

}

