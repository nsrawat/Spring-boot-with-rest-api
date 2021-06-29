package com.neosoft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.model.UserEntity;

public interface UserRepository  extends JpaRepository<UserEntity,Integer> {

	Optional<UserEntity> findByFirstName(String firstName);

	Optional<UserEntity> findByPincode(Integer pincode);
	
	//List<UserEntity> sortDob(Sort dob);

}
