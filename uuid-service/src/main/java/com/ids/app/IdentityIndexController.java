package com.ids.app;

import com.commons.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/identity")
public class IdentityIndexController {


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    IdentityService identityService;

    @PostMapping("/new")
    public ResponseEntity<String> writeIdentityData(@RequestBody Identity identity){
        System.out.println("java object "+identity);
        identityService.write(identity);
        return ResponseEntity.ok("OBJECT CREATED!");
    }

    @GetMapping("/find/{id}")
    public User find(@PathVariable long id){
        Map<String, Long> params = new HashMap<>();
        params.put("id", id);
        return restTemplate.getForObject("http://unified-service/user/find/{id}", User.class,params);
    }

}
