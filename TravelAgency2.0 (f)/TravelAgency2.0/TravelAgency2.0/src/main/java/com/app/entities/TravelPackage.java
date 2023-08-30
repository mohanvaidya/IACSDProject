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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class TravelPackage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long packId;

	@Column(length = 30)
	@NotBlank
	private String name;
    
	@Column(length = 30)
	@NotBlank
	private String country;
	
	@Column(length = 30)
	@NotBlank
	private String city;
	
	@Column(length = 300)
	@NotBlank
	private String description;

	@Column(length = 50)
	@NotBlank
	private String accomodation;

	@Column(length = 30)
	@NotBlank
	private String duration;

	@Column(length = 20)
	@NotNull
	private double price;

	@Column(length = 300)
	@NotBlank
	private String activities;
	
	@Column(length = 300)
	@NotBlank
	private String photourl;

//	@OneToOne
//	@JoinColumn(name="bookingId")
//	private Booking booking;
	
//	@OneToOne(mappedBy = "travelPackage", cascade = javax.persistence.CascadeType.ALL, orphanRemoval = true)
//    private Booking booking;

}
