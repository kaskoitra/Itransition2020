package com.example.services.implementations;

import com.example.dto.User;
import com.example.services.AuthenticationService;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService
{

    @Autowired
    private UserService userService;

    @Override
    public User checkUser(String email, String password) {
        return userService.receiveUser(email, password);
    }
}
