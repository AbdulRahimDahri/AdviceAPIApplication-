package com.descenedigital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdviceDTO {
	
	 private Long id;
	    private String message;
	    private Double averageRating;
	    private Integer ratingCount;

}
