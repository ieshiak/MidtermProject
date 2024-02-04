package com.skilldistillery.artgallery.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Enumerated(EnumType.STRING)
	private Rate rate;

	@Column(name = "create_time")
	private LocalDateTime createTime;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "artwork_id")
	private Artwork artwork;

	public Rating() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Rate getRate() {
		return rate;
	}

	public void setRate(Rate rate) {
		this.rate = rate;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
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

	public void addUser(User user) {
		if (user != null && this.user == null) {
			this.user = user;
			user.getRatings().add(this);
		}
	}

	public void removeUser() {
		if (user != null) {
			user.getRatings().remove(this);
			user = null;
		}
	}

	public void addArtwork(Artwork artwork) {
		if (artwork != null && this.artwork == null) {
			this.artwork = artwork;
			artwork.getRatings().add(this);
		}
	}

	public void removeArtwork() {
		if (artwork != null) {
			artwork.getRatings().remove(this);
			artwork = null;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(artwork, createTime, id, rate, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rating other = (Rating) obj;
		return Objects.equals(artwork, other.artwork) && Objects.equals(createTime, other.createTime) && id == other.id
				&& rate == other.rate && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", rate=" + rate + ", createTime=" + createTime + "]";
	}

	

}
