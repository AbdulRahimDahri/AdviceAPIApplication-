package com.descenedigital.mapper;

import com.descenedigital.dto.AdviceDTO;
import com.descenedigital.model.Advice;

public class AdviceMapper {

	public static AdviceDTO toDTO(Advice a) {
		AdviceDTO dto = new AdviceDTO();
		dto.setId(a.getId());
		dto.setMessage(a.getMessage());
		dto.setAverageRating(a.getAverageRating());
		dto.setRatingCount(a.getRatingCount());
		return dto;
	}

}
