package com.skilldistillery.artgallery.data;

import java.util.List;

import com.skilldistillery.artgallery.entities.Comment;

public interface CommentDAO {

    Comment findById(int commentId);

    List<Comment> findAll();

    Comment create(Comment comment);

    Comment update(Comment comment);

    boolean delete(int commentId);

    List<Comment> findCommentsByUserId(int userId);
}
