package com.skilldistillery.artgallery.data;

import java.util.List;

import com.skilldistillery.artgallery.entities.Rating;

public interface RatingDAO {

    Rating findById(int ratingId);

    List<Rating> findAll();

    Rating create(Rating rating);

    Rating update(Rating rating);

    boolean delete(int ratingId);

	void ratingCount(int artworkId, int userId, String rate);


}
