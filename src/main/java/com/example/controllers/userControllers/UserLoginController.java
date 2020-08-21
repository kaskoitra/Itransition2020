package com.example.controllers.userControllers;

import com.example.dto.User;
import com.example.services.implementations.AuthenticationServiceImpl;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserLoginController {

    @Autowired
    AuthenticationServiceImpl authenticationService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/loginuser", method = RequestMethod.GET)
    public String registration(ModelMap model) {
        return "loginuser";
    }

    @RequestMapping(value = "/loginuser", method = RequestMethod.POST)
    public String userSave(ModelMap model, @RequestParam String email, String password) {
        authenticationService.chekUser(email, password);

        User user = userService.receiveUser(email, password);
        model.addAttribute("name", user.getRole().getTitle());
        return "home";
    }
}
