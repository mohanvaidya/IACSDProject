package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
	
	Optional<User> findByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.email = ?1 and u.password = ?2")
	User findByEmailAndPassword(String email,String password);
	 

//	User findByUsernameAndPassword(String username, String password);

}
