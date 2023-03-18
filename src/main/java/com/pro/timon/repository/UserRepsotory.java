package com.pro.timon.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.timon.entity.User;

public interface UserRepsotory extends JpaRepository<User, Long> {

	Optional<User> findByEmail( String email);

}
