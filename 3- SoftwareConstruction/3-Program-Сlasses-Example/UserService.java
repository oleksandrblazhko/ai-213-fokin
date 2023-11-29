package com.example.blazkolab9.service;

import com.example.blazkolab9.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService extends JpaRepository<User, Long> {

}
