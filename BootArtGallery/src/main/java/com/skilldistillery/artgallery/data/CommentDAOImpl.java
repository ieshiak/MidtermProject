package com.skilldistillery.artgallery.data;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.artgallery.entities.Comment;
import com.skilldistillery.artgallery.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	private UserDAO userDAO;
	@PersistenceContext
	private EntityManager em;

	@Override
	public Comment findById(int commentId) {
		Comment managed = em.find(Comment.class, commentId);
		return managed;
	}

	@Override
	public List<Comment> findAll() {
		String jpql = "SELECT c FROM Comment c";
		Query query = em.createQuery(jpql, Comment.class);
		return query.getResultList();
	}

	@Override
	public Comment create(Comment comment) {
		comment.setCreateTime(LocalDateTime.now());
		em.persist(comment);
		return comment;
	}

	@Override
	@Transactional
	public Comment update(Comment comment) {
		Comment managed = em.find(Comment.class, comment.getId());
		
		if( managed != null) {
			managed.setCommentText(comment.getCommentText());
			managed.setUpdateTime(comment.getUpdateTime());
		}
		return managed;
	}

	@Override
	@Transactional
	public boolean delete(int commentId) {
		Comment commentToDelete = findById(commentId);
		if(commentToDelete != null) {
			try {
				em.remove(commentToDelete);
				return true;
		       } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	        return false;
	}

	@Override
	public List<Comment> retrieveUserComments(String username) {
		try {
			System.out.println("Entering retrieveUserComments method");
			System.out.println("Provided username: " + username);
			User user = userDAO.findUserByUsername(username);

			if (user != null) {
				System.out.println("User found: " + user);

				return userDAO.findCommentsByUserId(user.getId());
			} else {
				throw new RuntimeException("User not found for username: " + username);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
