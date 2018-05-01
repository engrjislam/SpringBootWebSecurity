package com.maxpro.controller.api.user;

import com.maxpro.entity.User;
import com.maxpro.entity.custom.CustomError;
import com.maxpro.entity.custom.CustomUser;
import com.maxpro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
@RequestMapping("/api")
public class UserApiController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{userName}")
    public CustomUser getUser(@PathVariable("userName") String userName) {
        User user = userService.findByUsername(userName);
        CustomUser customUser = null;
        if (user != null)
            customUser = new CustomUser(user.getUserName(), user.isEnabled());
        return customUser;
    }

}
