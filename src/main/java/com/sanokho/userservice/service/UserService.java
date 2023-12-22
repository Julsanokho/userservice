package com.sanokho.userservice.service;

import com.sanokho.userservice.domain.Role;
import com.sanokho.userservice.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String userName);
    List<User> getUsers();
}
