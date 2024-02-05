package com.skilldistillery.artgallery.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.artgallery.entities.Artwork;
import com.skilldistillery.artgallery.entities.Comment;
import com.skilldistillery.artgallery.entities.Rating;
import com.skilldistillery.artgallery.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public User authenticateUser(String username, String password) {
		try {
			System.out.println("Entering authenticateUser method");
			System.out.println("Provided username: " + username);
			String query = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password";
			User user = em.createQuery(query, User.class).setParameter("username", username)
					.setParameter("password", password).getSingleResult();
			System.out.println("Authenticated User: " + user);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public User create(User user) {
		em.persist(user);
		return user;
	}

	@Override
	@Transactional
	public User update(User user) {
	User managed = em.find(User.class, user.getId());
	if(managed != null) {
		managed.setFirstName(user.getFirstName());
		managed.setLastName(user.getLastName());
		managed.setUsername(user.getUsername());
		managed.setPassword(user.getPassword());
	}
	return managed;
	}

	@Override
	@Transactional
	public boolean delete(int id) {
		User userToDelete = findById(id);
		if(userToDelete != null) {
			try {
				em.remove(userToDelete);
				return true;
		      } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return false;
	    }
	

	@Override
	public User findUserByUsername(String username) {
		String query = "SELECT u FROM User u WHERE u.username = :username";
		try {
			return em.createQuery(query, User.class).setParameter("username", username).getSingleResult();
		} catch (NoResultException e) {
			return null; // User not found
		}
	}

	@Override
	public List<Comment> findCommentsByUserId(int userId) {
		try {
			System.out.println("Entering findCommentsByUserId method");
			System.out.println("Provided userId: " + userId);
			String query = "SELECT c FROM Comment c WHERE c.user.id = :userId";
			List<Comment> comments = em.createQuery(query, Comment.class).setParameter("userId", userId)
					.getResultList();

			System.out.println("Retrieved Comments: " + comments);

			return comments;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Rating> findRatingsByUserId(int userId) {
		String query = "SELECT r FROM Rating r WHERE r.user.id = :userId";
		List<Rating> ratings = em.createQuery(query, Rating.class).setParameter("userId", userId)
				.getResultList();
		System.out.println("Retrieved Ratings: " + ratings);
		return ratings;
	}	

	@Override
	public User findById(int userId) {
	     User managed = em.find(User.class, userId);
	        return managed;
	    }
	}


