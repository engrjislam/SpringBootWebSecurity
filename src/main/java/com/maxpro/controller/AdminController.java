package com.maxpro.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private final String BASE_PATH = "/admin";
    private final String ADMIN_INDES_PAGE = BASE_PATH + "/index";

    @RequestMapping("")
    public String home() {
        return ADMIN_INDES_PAGE;
    }

}
