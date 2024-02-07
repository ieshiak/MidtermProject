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
        System.out.println("Entering findById method");
        Comment managed = em.find(Comment.class, commentId);
        return managed;
    }

    @Override
    public List<Comment> findAll() {
        System.out.println("Entering findAll method");
        String jpql = "SELECT c FROM Comment c";
        Query query = em.createQuery(jpql, Comment.class);
        List<Comment> comments = query.getResultList();
        System.out.println("Retrieved comments: " + comments);
        return comments;
    }

    @Override
    public Comment create(Comment comment) {
        System.out.println("Entering create method");
        comment.setCreateTime(LocalDateTime.now());
        em.persist(comment);
        System.out.println("Created comment: " + comment);
        return comment;
    }

    @Override
    @Transactional
    public Comment update(Comment comment) {
        System.out.println("Entering update method");
        Comment managed = em.find(Comment.class, comment.getId());
        
        if( managed != null) {
            managed.setCommentText(comment.getCommentText());
            managed.setUpdateTime(comment.getUpdateTime());
            System.out.println("Updated comment: " + managed);
        }
        return managed;
    }

    @Override
    @Transactional
    public boolean delete(int commentId) {
        System.out.println("Entering delete method");
        Comment commentToDelete = findById(commentId);
        if(commentToDelete != null) {
            try {
                em.remove(commentToDelete);
                System.out.println("Deleted comment: " + commentToDelete);
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

                List<Comment> comments = userDAO.findCommentsByUserId(user.getId());
                System.out.println("Retrieved comments for user: " + comments);
                return comments;
            } else {
                throw new RuntimeException("User not found for username: " + username);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
