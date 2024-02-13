package com.skilldistillery.artgallery.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skilldistillery.artgallery.entities.Artwork;
import com.skilldistillery.artgallery.entities.Comment;
import com.skilldistillery.artgallery.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
@Transactional
public class CommentDAOImpl implements CommentDAO {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private UserDAO userDAO;

	@Override
	public Comment findById(int commentId) {
		return em.find(Comment.class, commentId);
	}

	@Override
	public List<Comment> findAll() {
		String jpql = "SELECT c FROM Comment c";
		Query query = em.createQuery(jpql, Comment.class);
		List<Comment> comments = query.getResultList();
		return comments;
	}

	@Override
	@Transactional
	public Comment create(Comment comment, int userId, int artworkId) {
		try {
			User user = em.find(User.class, userId);
			Artwork artwork = em.find(Artwork.class, artworkId);

			comment.setUser(user);
			comment.setArtwork(artwork);

			em.persist(comment);

			return comment;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error creating comment: " + e.getMessage());
		}
	}

	@Override
	@Transactional
	public Comment update(Comment comment) {
		try {
			return em.merge(comment);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error updating comment: " + e.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean delete(int commentId) {
		Comment commentToDelete = findById(commentId);
		if (commentToDelete != null) {
			try {
				em.remove(commentToDelete);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Error deleting comment: " + e.getMessage());
			}
		}
		return false;
	}

	@Override
	public List<Comment> retrieveUserComments(String username) {
		User user = userDAO.findUserByUsername(username);
		if (user == null) {
			throw new IllegalArgumentException("User not found for username: " + username);
		}
		return user.getComments();
	}

	@Override
	public List<Comment> findCommentsByArtworkId(int artworkId) {
		String query = "SELECT c FROM Comment c WHERE c.artwork.id = :artworkId";
		List<Comment> comments = em.createQuery(query, Comment.class).setParameter("artworkId", artworkId)
				.getResultList();
		return comments;
	}
}
