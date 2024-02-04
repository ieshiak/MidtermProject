package com.skilldistillery.artgallery.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.artgallery.entities.Rating;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RatingDAOImpl implements RatingDAO{

	@PersistenceContext
	private EntityManager em;

	@Override
	public Rating findById(int ratingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rating> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rating create(Rating rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rating update(Rating rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int ratingId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Rating> findRatingsByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
