package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@NoArgsConstructor
//@AllArgsConstructor
@Setter
@Getter
@ToString
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long feedbackID;

	@Column(length = 100)
	private String comment;

	@NotNull(message = "rate something based on your experience")
	private int rating;

	@OneToOne
    @JoinColumn(name="userId")
    private User user;

}
