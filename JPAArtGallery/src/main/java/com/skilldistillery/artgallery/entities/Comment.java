package com.skilldistillery.artgallery.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "artwork_id")
	private Artwork artwork;

	@Column(name = "comment_text")
	private String commentText;

	@Column(name = "create_time")
	private LocalDateTime createTime;

	@Column(name = "update_time")
	private LocalDateTime updateTime;

	public Comment() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Artwork getArtwork() {
		return artwork;
	}

	public void setArtwork(Artwork artwork) {
		this.artwork = artwork;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
	    if (this.createTime == null) {
	        this.createTime = LocalDateTime.now();
	    }
	}


	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return id == other.id;
	}

	public void addArtwork(Artwork artwork) {
		if (artwork != null && !artwork.getComments().contains(this)) {
			this.artwork = artwork;
			artwork.getComments().add(this);
		}

	}

	public void removeArtwork(Artwork artwork) {
		if (user != null && artwork != null && artwork.getComments().contains(this)) {
		    artwork.getComments().remove(this);
		    user = null;
		    artwork = null; // Set artwork to null, not user
		}


	}
	
	

	@Override
	public String toString() {
		return "Comment [id=" + id + ", artwork=" + artwork + ", commentText=" + commentText + "]";
	}


}