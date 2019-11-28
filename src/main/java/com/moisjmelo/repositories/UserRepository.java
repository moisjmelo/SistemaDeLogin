package com.moisjmelo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moisjmelo.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
