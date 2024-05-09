package com.base.jwt.service;

import com.base.jwt.dao.RoleDao;
import com.base.jwt.dao.UserDao;
import com.base.jwt.entity.Role;
import com.base.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public User registerNewUser(User user)
    {
        return userDao.save(user);
    }

    //Adding Admin and user role
    public void initRolesAndUser()
    {
        //adding two role
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("This is an admin role for application");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for appliction");
        roleDao.save(userRole);

        //adding two user
        User adminUser = new User();
        adminUser.setUserName("admin@123");
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserPassword("adminPassword");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRoles(adminRoles);
        userDao.save(adminUser);

        User normalUser = new User();
        normalUser.setUserName("user@123");
        normalUser.setUserFirstName("user");
        normalUser.setUserLastName("user");
        normalUser.setUserPassword("userPassword");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        normalUser.setRoles(userRoles);
        userDao.save((normalUser));


    }
}
