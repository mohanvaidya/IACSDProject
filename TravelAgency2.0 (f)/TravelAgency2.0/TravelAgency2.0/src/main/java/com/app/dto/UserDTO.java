package com.app.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.app.entities.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.implementation.bind.MethodDelegationBinder.BindingResolver.Unique;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
   
//	@JsonProperty(access = Access.READ_ONLY)
	private long userId;

	@Column(length = 30)
	@NotBlank(message = "name must be provided")
	private String first_name;



	private String last_name;


	private String email;
   
	
 private Role role;

	
	private String password;

	
	private String ContactNo;

	
}
