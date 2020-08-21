package com.example.services;

import com.example.dto.User;

public interface UserService {

    void saveUser(String firstName, String lastName, String email, String password);

    User receiveUser(long id);

    User receiveUser(String email, String password);
}
