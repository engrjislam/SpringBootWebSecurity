package com.maxpro.controller;

import com.maxpro.entity.User;
import com.maxpro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;


@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ROLE_USER')")
public class UserController {

    private final String BASE_PATH = "/user";
    private final String USER_INDEX_PAGE = BASE_PATH + "/index";

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("metaTitle", "User");
        return USER_INDEX_PAGE;
    }

    @RequestMapping("/loggedinuser")
    @ResponseBody
    public User loggedInUser(Principal principal) {
        return userService.findByUsername(principal.getName());
    }

}
