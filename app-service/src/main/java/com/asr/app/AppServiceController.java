package com.asr.app;

import com.commons.entities.Identity;
import com.commons.entities.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class AppServiceController {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/id/new/")
    public String newUUid(@RequestBody Identity identity) {
        return restTemplate.postForObject("http://uuid-service/identity/new", identity, String.class);
    }


    @RequestMapping("/user/new/")
    public String newUser(@RequestBody User user) {
        return restTemplate.postForObject("http://unified-servic/user/new", user, String.class);
    }

    @RequestMapping("/id/find/{id}")
    public User readById(@PathVariable long id) {
        Map<String, Long> params = new HashMap<>();
        params.put("id", id);
        return restTemplate.getForObject("http://uuid-service/identity/find/{id}", User.class, params);
    }
}
