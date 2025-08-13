package com.descenedigital.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Advice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 2000)
	private String message;

	@Column(name = "rating_sum", nullable = false)
	private Double ratingSum = 0.0;

	@Column(name = "rating_count", nullable = false)
	private Integer ratingCount = 0;

	public Advice(String message) {
		this.message = message;
	}

// getters & setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Double getRatingSum() {
		return ratingSum == null ? 0.0 : ratingSum;
	}

	public void setRatingSum(Double ratingSum) {
		this.ratingSum = ratingSum;
	}

	public Integer getRatingCount() {
		return ratingCount == null ? 0 : ratingCount;
	}

	public void setRatingCount(Integer ratingCount) {
		this.ratingCount = ratingCount;
	}

	public synchronized void addRating(int value) {
		if (value < 1 || value > 5) {
			throw new IllegalArgumentException("Rating must be 1..5");
		}
		this.ratingSum = getRatingSum() + value;
		this.ratingCount = getRatingCount() + 1;
	}

	@Transient
	public Double getAverageRating() {
		int c = getRatingCount();
		if (c == 0)
			return 0.0;
		return getRatingSum() / c;
	}

}
