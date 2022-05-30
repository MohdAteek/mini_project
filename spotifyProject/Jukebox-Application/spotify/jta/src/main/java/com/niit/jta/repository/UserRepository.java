package com.niit.jta.repository;

import com.niit.jta.exceptions.UserNotFoundException;
import com.niit.jta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{
    public User findByUseridAndPassword(int userid, String password) ;
}
