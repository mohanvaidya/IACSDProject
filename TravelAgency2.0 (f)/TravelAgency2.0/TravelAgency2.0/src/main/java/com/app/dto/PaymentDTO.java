package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.entities.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

	private long paymentId;
//
//	private double amount;
//	@Enumerated(EnumType.STRING)
//	private PaymentMethod paymentMethod;
//	@Column(length = 20)
//	@DateTimeFormat(pattern = "yyyy-mm-dd")
//	private LocalDate paymentdate;
//
//	// Constructors, getters, setters
	//new
	private long bookingId;
	private double amount;
    private PaymentMethod paymentMethod;
    private LocalDate paymentdate;
    
}
