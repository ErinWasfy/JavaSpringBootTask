package com.devskiller.tasks.blog.service;

import com.devskiller.tasks.blog.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;

	@Test
	public void testToken()
	{
		String token=userService.authenticate("Nick","1234");
		assertEquals(token,"122");
	}
}
