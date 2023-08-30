package com.app.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.BookingDTO;
import com.app.dto.PaymentDTO;
import com.app.entities.Booking;
import com.app.entities.Feedback;
import com.app.entities.Payment;
import com.app.entities.TravelPackage;
import com.app.entities.User;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.BookingRepo;
import com.app.service.BookingService;
import com.app.service.FeedbackService;
import com.app.service.PaymentService;
import com.app.service.TravelPackageService;
import com.app.service.UserService;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepo bookingrepo;
	
	@Autowired
	private UserService userimp;
	
	@Autowired
	private PaymentService paymentimp;
	
	@Autowired
	private FeedbackService feedbackimp;
	
	@Autowired
	private TravelPackageService travelimp;
	

	@Autowired
	private ModelMapper mapper;

	@Override
	public BookingDTO bookPackage(BookingDTO bookingDto) {

		Booking booking = this.mapper.map(bookingDto, Booking.class);
		Booking bookedPackage = this.bookingrepo.save(booking);

		return this.mapper.map(bookedPackage, BookingDTO.class);

	}

	@Override

	public List<BookingDTO> getAllBookings() {
		List<Booking> bookings = bookingrepo.findAll();

		List<BookingDTO> collect = bookings.stream().map((book) -> this.mapper.map(book, BookingDTO.class))
				.collect(Collectors.toList());
		return collect;
	}
    @Override
	public void deletebooking(Long bookingID) {
		Booking booking = bookingrepo.findById(bookingID)
				.orElseThrow(() -> new ResourceNotFoundException("Booking", "bookingID", bookingID));
          this.bookingrepo.delete(booking);
	}
       @Override
    public BookingDTO getbookingById(Long bookingId) {
		Booking booking = bookingrepo.findById(bookingId)
				.orElseThrow(() -> new ResourceNotFoundException("Please proivide a valid id", "bookingId", bookingId));
  
		return this.mapper.map(booking, BookingDTO.class);
	}

	@Override
	public Booking addBooking(BookingDTO book) {
		Booking booking = mapper.map(book, Booking.class);
		
		User user = userimp.getUserById(book.getUserId()); // Fetch user by ID
	    Payment payment = paymentimp.getPaymentById(book.getPaymentId());
//	    Feedback feedback = feedbackimp.getFeedbackById(book.getFeedbackId());
	    TravelPackage travelPackage = travelimp.getTravelPackageById(book.getTravelPackageId());
	    
	    booking.setUser(user);
	    booking.setPayment(payment);

	    booking.setTravelPackage(travelPackage);
	    
	    return bookingrepo.save(booking);
	}

    
    

    
}
