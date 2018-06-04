package com.maxpro.support.service;

import com.maxpro.model.User;
import com.maxpro.support.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class FacebookSignUpService implements ConnectionSignUp{

    @Autowired
    private UserRepository userRepository;

    @Override
    public String execute(Connection<?> connection) {
        User user = new User();
        user.setUserName(connection.getDisplayName());
        user.setPassword(UUID.randomUUID().toString().substring(0,8));
        userRepository.save(user);
        return user.getUserName();
    }

}
