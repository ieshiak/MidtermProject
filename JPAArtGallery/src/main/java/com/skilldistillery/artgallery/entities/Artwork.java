package com.skilldistillery.artgallery.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Artwork {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="artwork_image")
	private String artworkImage;
	
	private String title;
	
	@Column(name="creation_year")
	private int creationYear;
	
	private String description;
	
    @OneToMany(mappedBy = "artwork")
    private List<Rating> ratings;

    @OneToMany(mappedBy = "artwork")
    private List<Comment> comments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArtworkImage() {
		return artworkImage;
	}

	public void setArtworkImage(String artworkImage) {
		this.artworkImage = artworkImage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCreationYear() {
		return creationYear;
	}

	public void setCreationYear(int creationYear) {
		this.creationYear = creationYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Artwork [id=" + id + ", artworkImage=" + artworkImage + ", title=" + title + ", creationYear="
				+ creationYear + ", description=" + description + ", ratings=" + ratings + ", comments=" + comments
				+ "]";
	}

	
	
	
	
	

}
