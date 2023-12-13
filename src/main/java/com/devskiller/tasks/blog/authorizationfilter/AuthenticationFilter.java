package com.devskiller.tasks.blog.authorizationfilter;

import com.devskiller.tasks.blog.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


public class AuthenticationFilter {//extends UsernamePasswordAuthenticationFilter {
//	private AuthenticationManager authenticationManager;
//
//	public AuthenticationFilter(AuthenticationManager authenticationManager) {
//		this.authenticationManager = authenticationManager;
//		setFilterProcessesUrl("/login");
//	}
//	@Override
//	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException
//	{
//		try
//		{
//			User creds = new ObjectMapper().readValue(request.getInputStream(), User.class);
//			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(creds.getUserName(), creds.getPassword(),new ArrayList<>()));
//		}
//        catch(IOException e)
//		{
//			throw new RuntimeException("Could not read request" + e);
//		}
//	}
//	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication authentication)
//	{
//		String token = Jwts.builder()
//		.setSubject(((User) authentication.getPrincipal()).getUserName())
//		.setExpiration(new Date(System.currentTimeMillis() + 864_000_000))
//		.signWith(SignatureAlgorithm.HS512, "SecretKeyToGenJWTs".getBytes())
//		.compact();
//		response.addHeader("Authorization","Bearer " + token);
//
//	}

}
