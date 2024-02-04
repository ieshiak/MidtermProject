package com.skilldistillery.artgallery.entities;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Artwork {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "artwork_image")
	private String artworkImage;

	private String title;

	@Column(name = "creation_year")
	private Year creationYear;

	private String description;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "artwork")
	private List<Rating> ratings;

	@OneToMany(mappedBy = "artwork")
	private List<Comment> comments;

	public Artwork() {

	}

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

	public Year getCreationYear() {
		return creationYear;
	}

	public void setCreationYear(Year creationYear) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(artworkImage, comments, creationYear, description, id, ratings, title, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artwork other = (Artwork) obj;
		return Objects.equals(artworkImage, other.artworkImage) && Objects.equals(comments, other.comments)
				&& Objects.equals(creationYear, other.creationYear) && Objects.equals(description, other.description)
				&& id == other.id && Objects.equals(ratings, other.ratings) && Objects.equals(title, other.title)
				&& Objects.equals(user, other.user);
	}

	public void addComment(Comment comment) {
		if (comments == null) {
			comments = new ArrayList<>();
		}
		if (!comments.contains(comment)) {
			comments.add(comment);
			comment.addArtwork(this);
		}

	}

	public void removeComment(Comment comment) {
		if (comments != null && comments.contains(comment)) {
			comments.remove(comment);
			comment.removeArtwork(this);
		}
	}

	public void addRating(Rating rating) {
		if (ratings == null) {
			ratings = new ArrayList<>();
		}
		if (!ratings.contains(rating)) {
			ratings.add(rating);
			rating.setArtwork(this);
		}
	}

	public void removeRating(Rating rating) {
		if (ratings != null && ratings.contains(rating)) {
			ratings.remove(rating);
			rating.setArtwork(null);
		}
	}

	@Override
	public String toString() {
		return "Artwork [id=" + id + ", artworkImage=" + artworkImage + ", title=" + title + ", creationYear="
				+ creationYear + ", description=" + description + "]";
	}

	
	
}
