package com.example.internetsale.service;

import com.example.internetsale.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

  @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
