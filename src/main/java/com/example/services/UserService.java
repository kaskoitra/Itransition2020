package com.example.services;

import com.example.entity.User;
import com.example.dto.UserDto;

import java.util.List;

public interface UserService {

    /**
     * Save user in the DB
     * @param user added user
     * @return saved user
     */
    User save(UserDto user);

    /**
     * Find all users in the DB
     * @return List<User> list of all users
     */
    List<User> findAll();

    /**
     * Delete user with this id
     * @param id for deleting user
     */
    void delete(long id);

    /**
     * Find one user in the DB
     * @param username for get user
     * @return User users with this username
     */
    User findOne(String username);

    /**
     * Find one user in the DB
     * @param id for get user
     * @return User users with this id
     */
    User findById(Long id);
}
