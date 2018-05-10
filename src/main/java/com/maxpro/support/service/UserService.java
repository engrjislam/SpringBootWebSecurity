package com.maxpro.support.service;

import com.maxpro.model.User;
import com.maxpro.support.repository.UserRepository;
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
