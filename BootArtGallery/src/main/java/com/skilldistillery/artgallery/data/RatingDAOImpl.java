package com.skilldistillery.artgallery.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.artgallery.entities.Artwork;
import com.skilldistillery.artgallery.entities.Rate;
import com.skilldistillery.artgallery.entities.Rating;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RatingDAOImpl implements RatingDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ArtworkDAO artworkDAO;

	@Override
	public Rating findById(int ratingId) {
		Rating managed = em.find(Rating.class, ratingId);
		return managed;
	}

	@Override
	public List<Rating> findAll() {
		String jpql = "SELECT r FROM Rating r";
		Query query = em.createQuery(jpql, Rating.class);
		return query.getResultList();
	}

	@Override
	public Rating create(Rating rating) {
		em.persist(rating);
		return rating;
	}

	@Override
	@Transactional
	public Rating update(Rating rating) {
		Rating managed = em.find(Rating.class, rating.getId());
		if (managed != null) {
			managed.setRate(rating.getRate());
			managed.setCreateTime(rating.getCreateTime());
		}
		return managed;
	}

	@Override
	@Transactional
	public boolean delete(int ratingId) {
		Rating ratingToDelete = findById(ratingId);
		if (ratingToDelete != null) {
			try {
				em.remove(ratingToDelete);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public void ratingCount(int artworkId, int userId, String rate) {

		
	}
	
}