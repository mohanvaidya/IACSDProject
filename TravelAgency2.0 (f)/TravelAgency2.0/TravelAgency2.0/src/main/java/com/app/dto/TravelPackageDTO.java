package com.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TravelPackageDTO {

	private long packId;
//
//	@Column(length = 30)
//	@NotBlank
//	private String name;
//    
//	@Column(length = 30)
//	@NotBlank
//	private String country;
//	
//	@Column(length = 30)
//	@NotBlank
//	private String city;
//	
//	@Column(length = 300)
//	@NotBlank
//	private String description;
//
//	@Column(length = 50)
//	@NotBlank
//	private String accomodation;
//
//	@Column(length = 30)
//	@NotBlank
//	private String duration;
//
//	@Column(length = 20)
//	@NotNull
//	private double price;
//
//	@Column(length = 300)
//	@NotBlank
//	private String activities;
//	
//	@Column(length = 300)
//	@NotBlank
//	private String photourl;
	
	//new
	private String name;
    private String country;
    private String city;
    private String description;
    private String accomodation;
    private String duration;
    private double price;
    private String activities;
    private String photourl;
	

}
