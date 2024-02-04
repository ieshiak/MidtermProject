package com.skilldistillery.artgallery.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.artgallery.entities.Artwork;
import com.skilldistillery.artgallery.entities.Comment;
import com.skilldistillery.artgallery.entities.Rating;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ArtworkDAOImpl implements ArtworkDAO{

	@PersistenceContext
	private EntityManager em;

	@Override
	public Artwork findById(int artworkId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artwork> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artwork create(Artwork artwork) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artwork update(Artwork artwork) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int artworkId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Comment> findCommentsByArtworkId(int artworkId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rating> findRatingsByArtworkId(int artworkId) {
		// TODO Auto-generated method stub
		return null;
	}

}
