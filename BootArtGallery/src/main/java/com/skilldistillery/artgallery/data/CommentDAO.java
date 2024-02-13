package com.skilldistillery.artgallery.data;

import java.util.List;

import com.skilldistillery.artgallery.entities.Comment;

public interface CommentDAO {

    Comment findById(int commentId);

    List<Comment> findAll();

    Comment update(Comment comment);

    boolean delete(int commentId);

    List<Comment> retrieveUserComments(String username);

	Comment create(Comment comment, int userId, int artworkId);

	List<Comment> findCommentsByArtworkId(int artworkId);

}
