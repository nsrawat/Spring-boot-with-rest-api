package com.neosoft.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.neosoft.exception.RecordNotFoundException;
import com.neosoft.model.UserEntity;
import com.neosoft.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public UserEntity saveUser(UserEntity userEntity) {
		return repository.save(userEntity);
	}

	public List<UserEntity> getUsers(){
		return repository.findAll();
	}

	public List<UserEntity> sortDob(@RequestParam String val){
		return repository.findAll(Sort.by(Direction.ASC, val));
	}

	public List<UserEntity> sortbyjoining(String val) {
		return repository.findAll(Sort.by(Direction.DESC, val));
	}

	public UserEntity getUsersByFirstName(String firstName){
		return repository.findByFirstName(firstName).orElse(null);
	}

	public UserEntity getUsersByPincode(Integer pincode){
		return repository.findByPincode(pincode).orElse(null);
	}

	public String deleteUser(int userId) {
		return "users deleted !!"+userId;
	}

	public String deleteUsers(int userId) {
		repository.deleteById(userId);
		return "users deleted !!"+userId;
	}

	public String updateUsers(UserEntity entity, Integer userId) throws	RecordNotFoundException
	{
		Optional<UserEntity> users = repository.findById(userId);

		if(users.isPresent()) { 
			UserEntity newEntity = users.get();
			newEntity.setEmailId(entity.getEmailId());
			newEntity.setFirstName(entity.getFirstName());
			newEntity.setLastName(entity.getLastName());
			newEntity.setAddress(entity.getAddress());
			newEntity.setContactNo(entity.getContactNo());
			newEntity.setDesignation(entity.getDesignation());
			newEntity.setDob(entity.getDob());
			newEntity.setJoinDate(entity.getJoinDate());
			newEntity.setPincode(entity.getPincode());

			newEntity = repository.save(newEntity);

			return "user upadated: "+ userId; 
		}
		else {
			return "USER NOT FOUND: "+ userId;
		}

	}
}
