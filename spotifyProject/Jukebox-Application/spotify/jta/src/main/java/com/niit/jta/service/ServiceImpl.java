package com.niit.jta.service;

import com.niit.jta.exceptions.UserNotFoundException;
import com.niit.jta.model.User;
import com.niit.jta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements UserService{


    private UserRepository userRepository;

    @Autowired
    public ServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User authenticateUser(int userid, String password) throws UserNotFoundException{
        User user=userRepository.findByUseridAndPassword(userid,password);
        if(user!=null){
            return user;
        }
        else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
