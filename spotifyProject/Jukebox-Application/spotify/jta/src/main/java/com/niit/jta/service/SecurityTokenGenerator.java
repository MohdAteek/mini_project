package com.niit.jta.service;

import com.niit.jta.model.User;

import java.util.Map;

public interface SecurityTokenGenerator
{
    public Map<String , String> generateToken(User user);
}
