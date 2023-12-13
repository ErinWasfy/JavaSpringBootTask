package com.devskiller.tasks.blog.service;

import com.devskiller.tasks.blog.exception.ResourceNotFoundException;
import com.devskiller.tasks.blog.model.Project;
import com.devskiller.tasks.blog.model.User;
import com.devskiller.tasks.blog.model.dto.UserDto;
import com.devskiller.tasks.blog.repository.EmpProjectRepository;
import com.devskiller.tasks.blog.repository.UserRepository;
import com.devskiller.tasks.blog.rest.UserController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {


	UserRepository userRepository;
 //  private BCryptPasswordEncoder bCryptPasswordEncoder;
	EmpProjectRepository empProjectRepository;
	@Autowired
	public UserService(UserRepository repo,EmpProjectRepository empProj)
	{
		this.userRepository=repo;
		this.empProjectRepository=empProj;
	//	this.bCryptPasswordEncoder=bCryptPasswordEncoder;
	}
//	private final Logger logger= LogManager.getLogger(Project.class);

	public String authenticate(String userName,String password)
	{
		Optional<User> userAuthenticated =userRepository.login(userName,password);
		if(userAuthenticated.isPresent())
		{
			String token= UUID.randomUUID().toString();
			User user=userAuthenticated.get();
             user.setToken(token);
			 userRepository.save(user);
			 return token;
		}
    return null;
	}
	public Boolean validLogin(String userName,String password)
	{
		Optional<User> userIsAuthenticated=userRepository.login(userName,password);
		if(userIsAuthenticated.isPresent())
		{
			return true;
		}
		return false;
	}

	public UserDto findTokenById(Long userId)
	{
		return userRepository.findByToken(1L).map(usr->new UserDto(usr.getUserName(),usr.getPassword())).orElse(null);
	}

	public User saveEmpInProject(User user, Long projectId) throws ResourceNotFoundException {
     User projectUser= empProjectRepository.findById(projectId).map(proj->{
		 long userId=user.getId();
		 if(userId!=0L) {

			 try {
				User usr = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("Not found"));
				 proj.addNewUser(usr);
				 empProjectRepository.save(proj);
				 return usr;
			 } catch (ResourceNotFoundException e) {
				 e.printStackTrace();
			 }


		 }
      proj.addNewUser(user);
		 return userRepository.save(user);
	 }).orElseThrow(()->new ResourceNotFoundException("Not found"));
     return projectUser;
	}
//	public Long signUp(@RequestBody User user)
//	{
//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//		Long userId=userRepository.save(user).getId();
//		return userId;
//	}
	///prepare Data

}
