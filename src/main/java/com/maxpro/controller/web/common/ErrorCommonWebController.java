package com.maxpro.controller.common;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ErrorCommonController implements ErrorController {

    private final String BASE_PATH = "/common/error";
    private final String ACCESS_DENIED_PAGE = BASE_PATH + "/access_denied";
    private final String ERROR_PAGE = BASE_PATH + "/error";

    @RequestMapping(path = "/access-denied", method = RequestMethod.GET)
    public String accessDenied() {
        return ACCESS_DENIED_PAGE;
    }

    /*@RequestMapping(path = "/error", method = RequestMethod.GET)
    @ResponseBody
    public CustomError error() {
        CustomError customError = new CustomError(404, "Page Not Found!");
        return customError;
    }*/

    @RequestMapping(path = "/error", method = RequestMethod.GET)
    public String error() {
        return ERROR_PAGE;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
