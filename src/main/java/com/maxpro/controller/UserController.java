package com.maxpro.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('USER')")
public class UserController {

    private final String BASE_PATH = "/user";
    private final String USER_INDEX_PAGE = BASE_PATH + "/index";

    @RequestMapping("")
    public String home() {
        return USER_INDEX_PAGE;
    }

}
