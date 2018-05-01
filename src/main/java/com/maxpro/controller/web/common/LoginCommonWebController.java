package com.maxpro.controller.web.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginCommonWebController {

    private final String BASE_PATH = "/common/login";
    private final String LOGIN_PAGE = BASE_PATH + "/login";

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        return LOGIN_PAGE;
    }

}
