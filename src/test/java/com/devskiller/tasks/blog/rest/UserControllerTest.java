package com.devskiller.tasks.blog.rest;

import com.devskiller.tasks.blog.exception.ResourceNotFoundException;
import com.devskiller.tasks.blog.model.Project;
import com.devskiller.tasks.blog.model.User;
import com.devskiller.tasks.blog.model.dto.UserDto;
import com.devskiller.tasks.blog.rest.AbstractControllerTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserControllerTest extends AbstractControllerTest {

	@Test
	public void shouldReturnFoundUser() throws ResourceNotFoundException {
		UserDto tokenByUser=new UserDto("nick","1234");
		when(userService.findTokenById(1L)).thenReturn(tokenByUser);
		try {
			mockMvc.perform(get("/api/token/1").contentType(APPLICATION_JSON).accept(APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(result -> {
					assert(result.getRequest()).isRequestedSessionIdValid();

				})
				.andExpect(jsonPath("$.username",is("nick")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
