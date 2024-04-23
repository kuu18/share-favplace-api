package com.pandaman.sharefavplaceapi.repository;


import com.pandaman.sharefavplaceapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
