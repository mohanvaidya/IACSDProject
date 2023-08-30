package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long BookingId;
	
	@Column(length = 20)
	private String custName;
	
	@Column(length = 30, unique = true)
	@NotBlank
	@Email
	private String email;
	
	@Column
	@Length(min = 10,max = 10)
	@NotBlank
	@Pattern(regexp = "^[789]\\d{9}")
	private String ContactNo;
	
	@Column
	private int travelers;
	
	@Column(length = 20)
	@Future(message = "enter a valid travel date")
	@DateTimeFormat( pattern = "yyyy-mm-dd")
	private LocalDate BookingDate;
	
	@Column(length = 30)
	@NotNull
	private double TotalCost;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="userId")
//	private User user;
 //newa
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userId")
    private User user;
	
	@OneToOne
	@JoinColumn(name="paymentId")
	private Payment payment;

//    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Payment payment;
//
//    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Feedback feedback;

    @ManyToOne
    @JoinColumn(name = "packageId")
    private TravelPackage travelPackage;
	
	
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name="UserBookingId") private User userBooking;
	 */
	/*
	 * @OneToOne(mappedBy = "UserPackges",cascade = CascadeType.ALL,orphanRemoval =
	 * true) private List<Package>packages=new ArrayList<>();
	 */
	
	/*
	 * @OneToMany(mappedBy = "Feedback",cascade = CascadeType.ALL,orphanRemoval =
	 * true) private List<Feedback>feedbacks=new ArrayList<>();
	 */
	/*
	 * @OneToOne(mappedBy = "UserPayments",cascade = CascadeType.ALL, orphanRemoval
	 * = true) private List<Payment>payments=new ArrayList<>();
	 */
	
}
