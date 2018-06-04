package com.maxpro.controller.api.user;

import com.maxpro.model.User;
import com.maxpro.model.json.JsonUser;
import com.maxpro.support.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class UserApiController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{userName}")
    public JsonUser getUser(@PathVariable("userName") String userName) {
        User user = userService.findByUsername(userName);
        JsonUser jsonUser = null;
        if (user != null)
            jsonUser = new JsonUser(user.getUserName(), user.isEnabled());
        return jsonUser;
    }

}
