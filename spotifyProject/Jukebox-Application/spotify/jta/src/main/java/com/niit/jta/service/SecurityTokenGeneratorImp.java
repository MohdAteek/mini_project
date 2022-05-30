package com.niit.jta.service;

import com.niit.jta.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class SecurityTokenGeneratorImp implements SecurityTokenGenerator{
    @Override
    public Map<String, String> generateToken(User user)
    {
        Date cd = new Date();
        cd.setMinutes(cd.getMinutes()+5);
        System.out.println("\n\n Existing claims : "+Jwts.claims().values());
        //generate token based on userInfo , return as Map
        String jwtToken = Jwts.builder()
                .setSubject("User Name : "+user.getUsername() +" Email : "+user.getEmailid()
                        +" Password : "+user.getPassword()+" Address : "+user.getAddress())
                .setIssuedAt(new Date())
                .setExpiration(cd)  // current date +5 minutes
                .signWith(SignatureAlgorithm.HS256,"mykey").compact();
        Map<String , String> map = new HashMap<>();
        map.put("token",jwtToken);
        map.put("message","User Successfully Logged In");
        return map;
    }
}
