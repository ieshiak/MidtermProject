package com.skilldistillery.artgallery.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class ArtworkTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Artwork artwork;

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
		artwork = em.find(Artwork.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		artwork = null;
	}

	@Test
	void test_Artwork_has_mappings() {
		assertNotNull(artwork);
		assertNotNull(artwork.getTitle());
		assertEquals("Moon View 1", artwork.getTitle());

	}

	@Test
	void test_Artwork_to_Comment() {
		assertNotNull(artwork.getComments());
		assertEquals(1, artwork.getComments().size());

	}

	@Test
	void test_Artwork_to_Rating() {
		assertNotNull(artwork.getComments());
		assertEquals(1, artwork.getRatings().size());

	}

	@Test
	void test_Artwork_to_User() {
		assertNotNull(artwork.getUser());
		assertEquals(1, artwork.getUser().getId());

	}
}
