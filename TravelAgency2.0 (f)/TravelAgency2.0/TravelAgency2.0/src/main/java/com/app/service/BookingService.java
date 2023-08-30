package com.app.service;

import java.util.List;

import com.app.dto.BookingDTO;
import com.app.entities.Booking;


public interface BookingService {

	BookingDTO bookPackage(BookingDTO bookingDto);

	List<BookingDTO> getAllBookings();

	void deletebooking(Long bookingID);

	BookingDTO getbookingById(Long bookingId);

	Booking addBooking(BookingDTO book);

	
	
}
