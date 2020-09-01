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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<User> getListUsers(){
        return userService.findAll();
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }

    @RequestMapping(value="/{username}", method = RequestMethod.GET)
    public User getUserByUserName(@PathVariable(value = "username") String username){
        return userService.findOne(username);
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDto user){
        return userService.save(user);
    }
}
