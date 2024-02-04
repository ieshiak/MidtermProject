package com.skilldistillery.artgallery.data;

import java.util.List;

import com.skilldistillery.artgallery.entities.Artwork;
import com.skilldistillery.artgallery.entities.Comment;
import com.skilldistillery.artgallery.entities.Rating;

public interface ArtworkDAO {

    Artwork findById(int artworkId);

    List<Artwork> findAll();

    Artwork create(Artwork artwork);

    Artwork update(Artwork artwork);

    boolean delete(int artworkId);

    List<Comment> findCommentsByArtworkId(int artworkId);

    List<Rating> findRatingsByArtworkId(int artworkId);
}
