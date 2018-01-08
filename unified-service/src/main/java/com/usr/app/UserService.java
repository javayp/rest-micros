package com.usr.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void write(User user){
        userRepo.save(user);
    }

    public User findUser(long id){
        User user=userRepo.findOne(id);
        System.out.println(user);
        return user;
    }
}
