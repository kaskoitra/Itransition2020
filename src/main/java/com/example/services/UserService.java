package com.example.services;

import com.example.dto.User;

public interface UserService {

    /**
     * Saving a new user
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     */
    void saveUser(String firstName, String lastName, String email, String password);

    /**
     * Search for a user by his ID
     * @param id User's id
     * @return User with this id
     */
    User receiveUser(long id);

    /**
     * User authentication
     * @param email User's email
     * @param password User's password
     * @return User if credentials are valid
     */
    User receiveUser(String email, String password);
}
