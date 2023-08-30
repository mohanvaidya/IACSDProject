package com.app.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.UserDTO;
import com.app.entities.User;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.UserRepository;
import com.app.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	// dep : user dao
	@Autowired
	private UserRepository userRepo;

	@Autowired(required = true)
	private ModelMapper mapper;
  
	
	
	@Override
	public UserDTO registerNewUser(UserDTO userDto) {
		User user = this.mapper.map(userDto, User.class);
		User savedUser = this.userRepo.save(user);
		return this.mapper.map(savedUser, UserDTO.class);
	}
	

	@Override
	public UserDTO updateUser(UserDTO userDto, Long userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Not a Valid User ", "id", userId));

		
		user.setFirst_name(userDto.getFirst_name());
		user.setLast_name(userDto.getLast_name());
		user.setEmail(userDto.getEmail());
		user.setContactNo(userDto.getContactNo());
		user.setRole(userDto.getRole());
		user.setPassword(userDto.getPassword());
		User updateUser = this.userRepo.save(user);
  
		return this.mapper.map(updateUser, UserDTO.class);
	}

	@Override
	public User getUserById(Long userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Please proivide a valid id", "userid", userId));
  
		return this.mapper.map(user, User.class);
	}

	@Override
	public String deleteUserDetails(Long userID) {
		String mesg = "User id invalid , can't delete user details ";
		if (userRepo.existsById(userID)) {
			userRepo.deleteById(userID);
			mesg = "User with ID=" + userID + "  deleted !";
		}
		return mesg;
	}
     @Override
	public List<UserDTO> getAllUsers() {
		List<User> users = this.userRepo.findAll();

		List<UserDTO> userDtos = users.stream().map(user -> this.mapper.map(user, UserDTO.class))
				.collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public UserDTO getbyEmailAndPassword(String email, String password) {
		 System.out.println(email);
		 System.out.println(password);
		 User user=this.userRepo.findByEmailAndPassword(email, password);
		if(user!=null)
			return this.mapper.map(user,UserDTO.class);
		return null;
	}


	



}
