package com.maxpro.service;

import com.maxpro.entity.User;
import com.maxpro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }

}
