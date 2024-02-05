package com.skilldistillery.artgallery.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.artgallery.entities.Artwork;
import com.skilldistillery.artgallery.entities.Comment;
import com.skilldistillery.artgallery.entities.Rating;
import com.skilldistillery.artgallery.entities.User;

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
	@Transactional
	public Artwork update(Artwork artwork) {
		Artwork managed = em.find(Artwork.class, artwork.getId());
		if(managed != null) {
			managed.setTitle(artwork.getTitle());
			managed.setDescription(artwork.getDescription());
			managed.setCreationYear(artwork.getCreationYear());
		}
		return managed;
	}

	@Override
	@Transactional
	public boolean delete(int artworkId) {
		Artwork artworkToDelete = findById(artworkId);
		if(artworkToDelete != null) {
			try {
				em.remove(artworkToDelete);
				return true;
		      } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
		return false;
	}

	@Override
	public List<Comment> findCommentsByArtworkId(int artworkId) {
		String query = "SELECT c FROM Comment c WHERE c.artwork.id = :artworkId";
		List<Comment> comments = em.createQuery(query, Comment.class).setParameter(artworkId, artworkId)
				.getResultList();
		return comments;
	}

	@Override
	public List<Rating> findRatingsByArtworkId(int artworkId) {
		String query = "SELECT r FROM Rating r WHERE r.artwork.id = :artworkId";
		List<Rating> ratings = em.createQuery(query, Rating.class).setParameter("artworkId", artworkId)
				.getResultList();
		return ratings;
	}

}
