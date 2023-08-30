package com.app.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.BookingDTO;
import com.app.dto.PaymentDTO;
import com.app.dto.TravelPackageDTO;
import com.app.entities.Booking;
import com.app.entities.Payment;
import com.app.entities.TravelPackage;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.PaymentRepository;
import com.app.service.PaymentService;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private ModelMapper mapper;


	@Override
	public PaymentDTO makepayment(PaymentDTO paymentDto) {

		Payment payment = this.mapper.map(paymentDto, Payment.class);
		Payment paymentreceipt = this.paymentRepository.save(payment);

		return this.mapper.map(paymentreceipt, PaymentDTO.class);

	}

	@Override

	public List<PaymentDTO> getAllpayments() {
		List<Payment> payments = paymentRepository.findAll();

		List<PaymentDTO> collect = payments.stream().map((payment) -> this.mapper.map(payment, PaymentDTO.class))
				.collect(Collectors.toList());
		return collect;
	}

	@Override
	public Payment getPaymentById(Long paymentId) {
		return paymentRepository.findById(paymentId)
                .orElseThrow();
	
	}
       
	
	
}
