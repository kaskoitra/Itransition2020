package com.example.controllers.userControllers;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.services.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.annotation.Resource;

/**
 *Controller for to get, save and delete users
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Resource
    private UserService userService;

    /**
     *Private controller for get all users
     *
     * @return List<User> all users in the DB
     */
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<User> getListUsers(){
        return userService.findAll();
    }

    /**
     *Private controller for get user
     *
     * @return User user by id
     */
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }

    /**
     *Public controller for get user
     *
     * @return User user by username
     */
    @RequestMapping(value="/{username}", method = RequestMethod.GET)
    public User getUserByUserName(@PathVariable(value = "username") String username){
        return userService.findOne(username);
    }


    /**
     *Public controller for save user
     *
     * @return User saved user
     */
    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDto user){
        return userService.save(user);
    }

    /**
     *Public controller for delete user
     *
     * @param id user's Id for deleting
     * @return boolean is user deleted
     */
    @RequestMapping(value="/users/{id}", method = RequestMethod.DELETE)
    public boolean deleteUser(@PathVariable(value = "id") long id){
        userService.delete(id);
        return true;
    }
}
