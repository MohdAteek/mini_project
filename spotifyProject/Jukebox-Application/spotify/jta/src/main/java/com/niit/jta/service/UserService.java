package com.niit.jta.service;

import com.niit.jta.exceptions.UserNotFoundException;
import com.niit.jta.model.User;

import java.util.List;

public interface UserService
{
    public User saveUser(User user);
    public User authenticateUser(int userid , String password) throws UserNotFoundException;
    public List<User> getAllUser();
}
