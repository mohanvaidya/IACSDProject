package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.apiresponse.ApiResponse;
import com.app.dto.UserDTO;
import com.app.entities.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	public UserController() {
		System.out.println("inside user controller");
	}

	@Autowired
	private UserService userService;

	/*
	 * @Autowired private AuthenticationManager authMgr;
	 * 
	 * 
	 * // http://host:port/users/signup , method=POST
	 * 
	 * @PostMapping("/signup") public ResponseEntity<?>
	 * signupUser(@RequestBody @Valid UserDTO dto) {
	 * System.out.println("in signup user " + dto);
	 * 
	 * return
	 * ResponseEntity.status(HttpStatus.CREATED).body(userService.registerNewUser(
	 * dto)); }
	 */
	// http://host:port/users/signin , method=POST

	@GetMapping("/")
	public List<UserDTO>getAllUsers(){
	System.out.println("---Users List---");
		return userService.getAllUsers();
	}

	@PostMapping("/")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDto) {
		UserDTO registerUserDto = this.userService.registerNewUser(userDto);
		return new ResponseEntity<>(registerUserDto, HttpStatus.CREATED);
	}

	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable long userId,@RequestBody UserDTO userDto) {
		UserDTO updateUserDto = this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updateUserDto);
	}

	@DeleteMapping("/{userID}")
	public ApiResponse deleteuserdetails(@PathVariable Long userID) {
		System.out.println("delete user details"+userID);
		return  new ApiResponse(userService.deleteUserDetails(userID), true);
		
	}
	
	
//	
//	public ApiResponse deleteEmpDetails(@PathVariable Long empId) {
//		System.out.println("in del emp dtls " + empId);
//		// invoke service layer method , get it's resp , wrap it in a DTO -->
//		// marshalling --> json --sent to fron end
//		return new ApiResponse(empService.deleteEmpDetails(empId));
//	}
	
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable Long userId) {
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
//	public ResponseEntity<UserDTO> getSingleUser(@PathVariable Long userId) {
//		return ResponseEntity.ok(this.userService.getUserById(userId));
//	}

}