package com.app.dto;

import com.app.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRespDTO {	
//	private Long id;
//	private String email;
//	private String firstName;
//	private String lastName;
//	private UserRole role;
	private String jwt;
}
