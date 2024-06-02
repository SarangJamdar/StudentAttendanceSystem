package com.code.bug.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.bug.model.LoginUser;
import com.code.bug.repository.UserRepository;
@Service
public class UserService {
	
    @Autowired
    private UserRepository userRepository;

    public void saveUser(LoginUser user) {
        this.userRepository.save(user);
    }
    
    public LoginUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
