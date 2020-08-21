package com.example.controllers.userControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestUserPrivatePageController {

    @RequestMapping(value = "/user/private", method = RequestMethod.GET)
    public String registration(ModelMap model) {
        return "privateuser";
    }
}
