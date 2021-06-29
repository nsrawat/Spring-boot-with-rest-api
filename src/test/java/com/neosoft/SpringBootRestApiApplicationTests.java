package com.neosoft;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.neosoft.model.UserEntity;
import com.neosoft.repository.UserRepository;
import com.neosoft.service.UserService;

@SpringBootTest
class SpringBootRestApiApplicationTests {
	   
	@Autowired
	private UserService service;

	@MockBean
	private UserRepository repository;

	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new UserEntity(10, "akash", "singh","akash@gmail.com", "python", "indore",  "2001/01/5", "2021/05/14", 4789014222L, 758642))
				.collect(Collectors.toList()));
		assertEquals(1, service.getUsers().size());
	}
		   
	@Test
	public void saveUsersTest() {

		UserEntity users = new UserEntity(10, "akash", "singh","akash@gmail.com", "python", "indore",  "2001/01/5", "2021/05/14", 4789014222L, 758642);
		when(repository.save(users)).thenReturn(users);
		assertEquals(users, service.saveUser(users));
	}

	@Test
	public void deleteUsersTest () {
		int userId=19;
		service.deleteUser(19);
		assertThat(repository.existsById(19)).isFalse();
	}

}
