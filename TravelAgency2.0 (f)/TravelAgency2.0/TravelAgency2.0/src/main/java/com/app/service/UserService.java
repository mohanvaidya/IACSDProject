package com.app.service;

import java.util.List;

import com.app.dto.UserDTO;
import com.app.entities.User;

public interface UserService {

	UserDTO registerNewUser(UserDTO user);

	User getUserById(Long userId);

	String deleteUserDetails(Long userID);

	List<UserDTO> getAllUsers();

	UserDTO getbyEmailAndPassword(String email, String password);

	UserDTO updateUser(UserDTO userDto, Long userId);

}
