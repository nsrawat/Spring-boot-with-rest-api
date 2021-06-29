package com.neosoft;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.neosoft.model.UserEntity;
import com.neosoft.repository.UserRepository;
import com.neosoft.service.UserService;

class UserTest {

	@Autowired
	private UserService service;

	@MockBean
	private UserRepository urepository;

	@Test
	public void saveUserTests() {

		UserEntity users = new UserEntity(10, "akash", "singh","akash@gmail.com", "python", "indore",  "2001/01/5", "2021/05/14", 4789014222L, 758642);
		when(urepository.save(users)).thenReturn(users);
		assertEquals(users, service.saveUser(users));
	}
	
	@Test
	public void testDelete () {
		int userId=19;
		service.deleteUser(19);
		assertThat(urepository.existsById(19)).isFalse();
	}

}
