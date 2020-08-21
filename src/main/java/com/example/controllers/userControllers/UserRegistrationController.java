package com.example.controllers.userControllers;

import com.example.services.UserService;
import com.example.services.implementations.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registrationuser", method = RequestMethod.GET)
    public String registration(ModelMap model) {
        return "registrationuser";
    }

    @RequestMapping(value = "/registrationuser", method = RequestMethod.POST)
    public String userSave(@RequestParam String first, String last, String email, String password) {
        userService.saveUser(first, last, email, password);
        return "redirect:/loginuser";
    }
}
