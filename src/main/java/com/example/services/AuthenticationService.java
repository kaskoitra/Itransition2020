package com.example.services;

import com.example.dto.User;

public interface AuthenticationService {

    /**
     * Checking the validity of user credentials
     * @param email user's email
     * @param password user's password
     * @return valid logged in user
     */
    User checkUser(String email, String password);
}
