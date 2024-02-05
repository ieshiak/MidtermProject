package com.skilldistillery.artgallery.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.artgallery.entities.Artwork;
import com.skilldistillery.artgallery.entities.Comment;
import com.skilldistillery.artgallery.entities.Rating;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ArtworkDAOImpl implements ArtworkDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Artwork findById(int artworkId) {
		System.out.println("Debug: Entered findById method with artworkId: " + artworkId);
		Artwork artwork = em.find(Artwork.class, artworkId);

		if (artwork != null) {
			System.out.println("Debug: Found artwork with details: " + artwork);
		} else {
			System.out.println("Debug: Artwork not found with artworkId: " + artworkId);
		}
		return artwork;
	}

	@Override
	public List<Artwork> findAll() {
		String jpql = "SELECT a FROM Artwork a";
		Query query = em.createQuery(jpql, Artwork.class);
		return query.getResultList();
	}

	@Override
    public Artwork create(Artwork artwork) {
        em.persist(artwork);
        return artwork;
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
