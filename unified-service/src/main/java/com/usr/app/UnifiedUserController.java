package com.usr.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UnifiedUserController {


    @Autowired
    private UserService userService;

    @RequestMapping("/new")
    public ResponseEntity<String> createUser(@RequestBody User user){
        userService.write(user);
        return ResponseEntity.ok("USER CREATED!");
    }

    @RequestMapping("/find/{id}")
    public User findUserById(@PathVariable long id){
       return userService.findUser(id);
    }
}
