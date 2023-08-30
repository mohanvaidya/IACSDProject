package com.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDTO {

//	private long feedbackID;
//
//	@Column(length = 100)
//	@NotBlank
//	private String comment;
//
//	@NotNull(message = "rate something based on your experience")
//	
//	private int rating;
	// new
	private String comment;
	private int rating;
	private Long userId;
}
