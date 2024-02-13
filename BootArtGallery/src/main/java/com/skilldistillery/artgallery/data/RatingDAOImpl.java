package com.skilldistillery.artgallery.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	private ArtworkDAO artworkDAO;

	@Autowired
	public void setArtworkDAO(ArtworkDAO artworkDAO) {
		this.artworkDAO = artworkDAO;
	}

	@Override
	public Rating findById(int ratingId) {
		Rating rating = em.find(Rating.class, ratingId);
		return rating;
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
	public List<Rating> findRatingsByArtworkId(int artworkId) {
		String jpql = "SELECT r FROM Rating r WHERE r.artwork.id = :artworkId";
		return em.createQuery(jpql, Rating.class).setParameter("artworkId", artworkId).getResultList();
	}

}