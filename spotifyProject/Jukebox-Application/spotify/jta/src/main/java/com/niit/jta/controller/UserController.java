package com.niit.jta.controller;

import com.niit.jta.exceptions.UserNotFoundException;
import com.niit.jta.model.User;
import com.niit.jta.service.SecurityTokenGenerator;
import com.niit.jta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("*")
@RestController
public class UserController {

    private UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService , SecurityTokenGenerator securityTokenGenerator){
        this.userService=userService;
        this.securityTokenGenerator=securityTokenGenerator;
    }

//  http://localhost:8080/register  (post)
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }


//    http://localhost:8080/userservice/getalluser  (get)
    @GetMapping("/userservice/getalluser")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }

//    http://localhost:8080/login  (post)
    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody User user) throws UserNotFoundException {
        Map<String,String> map = null;
        try{
            User resultuser = userService.authenticateUser(user.getUserid(), user.getPassword());
            if(resultuser.getUserid()==user.getUserid()){

                // generate token , add token to map
                // map info to be send as response

                map = securityTokenGenerator.generateToken(resultuser);
            }
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        catch (UserNotFoundException ex){
            throw new UserNotFoundException();
        }
        catch (Exception ex){
            return new ResponseEntity<>("Other Exception",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
