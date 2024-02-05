package com.skilldistillery.artgallery.data;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.artgallery.entities.Comment;
import com.skilldistillery.artgallery.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment create(Comment comment) {
		comment.setCreateTime(LocalDateTime.now());
		em.persist(comment);
		return comment;
	}

	@Override
	public Comment update(Comment comment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int commentId) {
		// TODO Auto-generated method stub
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
