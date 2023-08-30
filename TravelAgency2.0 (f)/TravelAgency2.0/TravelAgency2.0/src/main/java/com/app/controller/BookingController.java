package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.apiresponse.ApiResponse;
import com.app.dto.BookingDTO;
import com.app.dto.TravelPackageDTO;
import com.app.entities.Booking;
import com.app.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {

	@Autowired
	private BookingService bookingservice;

//	@PostMapping("/")
//	public ResponseEntity<BookingDTO> bookpackage(@RequestBody BookingDTO bookingDto) {
//
//		BookingDTO bookpackage = bookingservice.bookPackage(bookingDto);
//
//		return new ResponseEntity<BookingDTO>(bookpackage, HttpStatus.OK);
//
//	}
	
	@PostMapping("/")
	public Booking addBooking(@RequestBody BookingDTO book) {
		return bookingservice.addBooking(book);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<BookingDTO>>getAllBookings(){
		
		List<BookingDTO>bookings=bookingservice.getAllBookings();
		return ResponseEntity.ok(bookings);
		
	}

	  @DeleteMapping("{bookingID}")
	  public ResponseEntity<ApiResponse>deletebooking(@PathVariable Long bookingID){
		  
		 this.bookingservice.deletebooking(bookingID);
		return  new ResponseEntity<ApiResponse>(new ApiResponse("booking deleted succeessfully.!",true),HttpStatus.OK);
		  
		  
	  }
	  @GetMapping("/{bookingId}")
		public ResponseEntity<BookingDTO> getSingleBooking(@PathVariable Long bookingId) {
			return ResponseEntity.ok(bookingservice.getbookingById(bookingId));
		}
}
