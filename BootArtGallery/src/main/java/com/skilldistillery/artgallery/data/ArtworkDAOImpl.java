package com.skilldistillery.artgallery.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	private CommentDAO commentDAO;

	@Autowired
	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

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
		return em.merge(artwork);
	}

	@Override
	@Transactional
	public boolean delete(int artworkId) {
		try {
			Artwork artworkToDelete = findById(artworkId);
			if (artworkToDelete != null) {
				// Delete associated comments
				List<Comment> comments = commentDAO.findCommentsByArtworkId(artworkId);
				for (Comment comment : comments) {
					commentDAO.delete(comment.getId());
				}

				em.remove(artworkToDelete);
				em.flush();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error deleting artwork with ID " + artworkId + ": " + e.getMessage());
		}
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
		String jpql = "SELECT r FROM Rating r WHERE r.artwork.id = :artworkId";
		return em.createQuery(jpql, Rating.class).setParameter("artworkId", artworkId).getResultList();
	}

	@Override
	public List<Artwork> findByKeyword(String keyword) {
		String jpql = "SELECT a FROM Artwork a WHERE LOWER(a.title) LIKE :keyword OR LOWER(a.description) LIKE :keyword";
		Query query = em.createQuery(jpql, Artwork.class);
		query.setParameter("keyword", "%" + keyword.toLowerCase() + "%");
		return query.getResultList();
	}

}
