package com.devskiller.tasks.blog.repository;

import com.devskiller.tasks.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	@Query(value = "select u from User u where u.userName=?1 and u.password=?2")
	 Optional<User> login(String userName,String password);
	@Query(value = "select u from User u where u.ID=?1")
	Optional<User> findByToken(Long userId);
}
