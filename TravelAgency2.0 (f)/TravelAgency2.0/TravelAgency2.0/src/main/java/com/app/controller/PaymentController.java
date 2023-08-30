package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PaymentDTO;
import com.app.entities.Payment;
import com.app.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;

	@GetMapping("/")
	public ResponseEntity<List<PaymentDTO>> getAllPayments() {

		List<PaymentDTO> packs = paymentService.getAllpayments();
		return ResponseEntity.ok(packs);

	}

	@PostMapping("/")
	public ResponseEntity<PaymentDTO> createpayment(@RequestBody PaymentDTO paymentDto) {

		PaymentDTO createpayment = paymentService.makepayment(paymentDto);

		return new ResponseEntity<PaymentDTO>(createpayment, HttpStatus.OK);

	}

	@GetMapping("/{paymentId}")
	public ResponseEntity<Payment> getSinglepayment(@PathVariable Long paymentId) {
		return ResponseEntity.ok(paymentService.getPaymentById(paymentId));
	}

}
