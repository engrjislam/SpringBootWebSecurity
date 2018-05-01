package com.maxpro.controller.web.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping({"", "/"})
public class HomeCommonWebController {

    private final String BASE_PATH = "/common/home";
    private final String HOME_INDEX_PAGE = BASE_PATH + "/index";

    @RequestMapping(path = "", method = RequestMethod.GET)
    public String index() {
        return HOME_INDEX_PAGE;
    }

}
