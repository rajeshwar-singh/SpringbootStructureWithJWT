package com.base.jwt.controller;

import com.base.jwt.entity.User;
import com.base.jwt.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    //@PostConstruct is used when we want to run a method on every build
    @PostConstruct
    public void initRolesAndUser()
    {
        userService.initRolesAndUser();
    }

    @PostMapping("/registerNewUser")
    public ResponseEntity<User> registerNewUser(@RequestBody User user)
    {
        userService.registerNewUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
