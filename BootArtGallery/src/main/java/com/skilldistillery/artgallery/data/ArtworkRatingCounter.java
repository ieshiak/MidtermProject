package com.skilldistillery.artgallery.data;

import java.util.HashMap;
import java.util.Map;

public class ArtworkRatingCounter {
    private Map<Integer, Integer> ratingCounts = new HashMap<>();

    // Method to increment the count for a given artwork ID
    public void incrementCount(int artworkId) {
        ratingCounts.put(artworkId, ratingCounts.getOrDefault(artworkId, 0) + 1);
    }

    // Method to get the count for a given artwork ID
    public int getCount(int artworkId) {
        return ratingCounts.getOrDefault(artworkId, 0);
    }
}
