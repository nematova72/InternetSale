package com.example.internetsale.service;

import com.example.internetsale.domain.User;
import com.example.internetsale.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
      this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

    public User create (User user){
    user.setPassword(passwordEncoder.encode(user.getPassword()));
      return  userRepository.save(user);
    }

    public Boolean checkUserName(String userName){
      return userRepository.existsByUserName(userName);
    }


}
