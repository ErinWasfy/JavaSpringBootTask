package com.devskiller.tasks.blog.rest;

import com.devskiller.tasks.blog.exception.ResourceNotFoundException;
import com.devskiller.tasks.blog.model.User;
import com.devskiller.tasks.blog.model.dto.UserDto;
import com.devskiller.tasks.blog.repository.UserRepository;
import com.devskiller.tasks.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RestController
@RequestMapping("/api")
public class UserController {

   UserService userService;
	@Autowired
	public UserController(UserService repo)
	{
		this.userService=repo;
	}
	@GetMapping("/user/{id}")
	public String login(@PathVariable("id") Long id,@RequestParam("username") String username, @RequestParam("password") String pwd) {
		//String token = getJWTToken(username);
		String token=userService.authenticate(username,pwd);
//		User user = usr.get();
//		user.setToken("token");
		return token;
	}
	@GetMapping(value="/token/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UserDto fetchToken(@PathVariable("id")Long id) {
		return userService.findTokenById(1L);
	}
	@PostMapping("/{Id}/post")

	public ResponseEntity<User> saveNewUser(@RequestBody User user,@PathVariable("Id") Long Id) throws ResourceNotFoundException {
		User users=userService.saveEmpInProject(user,Id);


		return new ResponseEntity<User>(users,HttpStatus.OK);
	}
//	private String getJWTToken(String username) {
//		String secretKey = "mySecretKey";
//		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
//			.commaSeparatedStringToAuthorityList("ROLE_USER");
//
//		String token = Jwts
//			.builder()
//			.setId("softtekJWT")
//			.setSubject(username)
//			.claim("authorities",
//				grantedAuthorities.stream()
//					.map(GrantedAuthority::getAuthority)
//					.collect(Collectors.toList()))
//			.setIssuedAt(new Date(System.currentTimeMillis()))
//			.setExpiration(new Date(System.currentTimeMillis() + 600000))
//			.signWith(SignatureAlgorithm.HS512,
//				secretKey.getBytes()).compact();
//
//		return "Bearer " + token;
//	}

	@GetMapping("/login")
	public ResponseEntity<Boolean> authenticateUser(@RequestParam("username") String userName,@RequestParam("password") String password)
	{
		if(userService.validLogin(userName,password))
     return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		return new ResponseEntity<Boolean>(false,HttpStatus.NO_CONTENT.NOT_FOUND);
	}
//	@PostMapping("/signup")
//	public ResponseEntity<Long> signUp(@RequestBody User user)
//	{
//		Long id=userService.signUp(user);
//		return new ResponseEntity<Long>(id,HttpStatus.FOUND);
//	}
}
