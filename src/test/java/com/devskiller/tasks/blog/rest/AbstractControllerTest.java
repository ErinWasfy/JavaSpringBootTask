package com.devskiller.tasks.blog.rest;

import com.devskiller.tasks.blog.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest
public abstract class AbstractControllerTest {

	@Autowired
	protected MockMvc mockMvc;
	@MockBean
	AccountService accountService;

	@MockBean
	protected PostService postService;

	@MockBean
	protected CommentService commentService;

	@MockBean
	protected UserService userService;

	@MockBean
	protected CarParkUBIService carParkUBIService;

	@MockBean
	protected ChargePointService chargePointService;

	@Autowired
	protected ObjectMapper objectMapper;

	@BeforeEach
	public void setUp() {
	Mockito.reset(postService, commentService,userService,accountService,chargePointService,carParkUBIService);

	}

}
