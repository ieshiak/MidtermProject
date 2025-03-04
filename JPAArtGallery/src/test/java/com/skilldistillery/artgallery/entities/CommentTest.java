package com.skilldistillery.artgallery.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class CommentTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Comment comment;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAArtGallery");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		comment = em.find(Comment.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		comment = null;
	}

	@Test
	void test_Comment_has_mappings() {
		assertNotNull(comment);
		assertNotNull(comment.getCommentText());
		assertEquals("whats up my boy", comment.getCommentText());

	}

	@Test
	void test_Comment_to_Artwork() {
		assertNotNull(comment.getArtwork());
		assertEquals(1, comment.getArtwork().getId());
	}

	@Test
	void test_Comment_to_User() {
		assertNotNull(comment.getUser());
		assertEquals(1, comment.getUser().getId());
	}
}