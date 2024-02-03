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

class RatingTest {

	private static EntityManagerFactory emf;
    private EntityManager em;
    private Rating rating;

    
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
        rating = em.find(Rating.class, 2);
    }

    @AfterEach
    void tearDown() throws Exception {
        em.close();
        rating = null;
    }
    
    @Test
    void test_Rating_has_mappings() {
    	assertNotNull(rating);
    	assertNotNull(rating.getRate());
    	assertEquals(Rate.Like, rating.getRate());
    	
    }
    
    @Test
	void test_Rating_has_User() {
		assertNotNull(rating);
		assertNotNull(rating.getUser());
	}

    @Test
   	void test_Rating_to_Artwork() {
   		assertNotNull(rating);
   		assertNotNull(rating.getArtwork());
   		assertEquals(2, rating.getArtwork().getId());
}
}