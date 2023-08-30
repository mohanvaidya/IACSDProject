package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@NoArgsConstructor
//@AllArgsConstructor
@Setter
@Getter
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	@Column(length = 30)
	@NotBlank(message = "first_name must be provided")
	private String first_name;
	
	
	@Column(length = 30)
	@NotBlank(message = "last_name must be provided")
	private String last_name;

	@Column(length = 30, unique = true)
	@NotBlank
	@Email
	private String email;

	@Enumerated(EnumType.STRING)
	@NotNull
	private Role role;

	@NotBlank
	@Length(min = 3, max = 8, message = "invalid password")
	private String password;

	@Length(min = 10,max = 10)
	@NotBlank
	@Pattern(regexp = "^[789]\\d{9}")
	private String ContactNo;
    
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Booking> bokings = new ArrayList<Booking>();


	/*
	 * @OneToMany(mappedBy = "User",cascade = CascadeType.ALL,orphanRemoval = true )
	 * //@Column(name = "Bookings") private List<Booking>bookings;//=new
	 * ArrayList<>();
	 */
	/*
	 * @OneToMany(mappedBy = "userPayment",cascade = CascadeType.ALL, orphanRemoval
	 * = true) private List<Payment> payments = new ArrayList<>();
	 */
}
