package com.skilldistillery.artgallery.data;

import java.util.List;

import com.skilldistillery.artgallery.entities.Artwork;
import com.skilldistillery.artgallery.entities.Comment;
import com.skilldistillery.artgallery.entities.Rating;
import com.skilldistillery.artgallery.entities.User;

public interface UserDAO {

	User authenticateUser(String username, String password);
	
	User findById(int userId);

	List<User> findAll();
	
    User create(User user);
	
    User update(User user);
	
    boolean delete(int id);
    
    List<User> findUsersByKeyword(String keyword);

    List<Artwork> findArtworkById(int artworkId);

    List<Comment> findCommentsByUserId(int userId);

    List<Rating> findRatingsByUserId(int userId);
}
	
	

	

