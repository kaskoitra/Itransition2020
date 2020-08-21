package com.example.services;

import com.example.dto.User;

public interface AuthenticationService
{

    User chekUser(String email, String password);
}
