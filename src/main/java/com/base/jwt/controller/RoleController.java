package com.base.jwt.controller;

import com.base.jwt.entity.Role;
import com.base.jwt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;
    @PostMapping("/createNewRole")
    public ResponseEntity<Role> createNewRole(@RequestBody Role role)
    {
        roleService.createNewRole(role);
        return new ResponseEntity<Role>(role,HttpStatus.OK);
    }
}
