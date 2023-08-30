package com.app.service;

import java.util.List;

import com.app.dto.BookingDTO;
import com.app.dto.PaymentDTO;
import com.app.entities.Payment;

public interface PaymentService {


	List<PaymentDTO> getAllpayments();

	PaymentDTO makepayment(PaymentDTO paymentDto);

	

	Payment getPaymentById(Long paymentId);


	

	
	

}
