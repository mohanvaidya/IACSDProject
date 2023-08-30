package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {

//	private long BookingId;

//	private String custName;
//	
//	private String email;
//	
//	private String contactNo;
//	
//	private int travelers;
//	
//	private int packId;
//
//	private LocalDate BookingDate;
//
//	
//	private double TotalCost;
//	
//	private Long userId;

//new
	 private Long bookingId;
	    private String custName;
	    private String email;
	    private String ContactNo;
	    private int travelers;
	    private LocalDate bookingDate;
	    private double totalCost;
	    private Long userId; // Store the user ID here
	    private Long paymentId; // Store the payment ID here
//	    private Long feedbackId; // Store the feedback ID here
	    private Long travelPackageId; // Store the travel package ID here
}
