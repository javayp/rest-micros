package com.ids.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentityService {

    @Autowired
    IdentityRepo identityRepo;

    public void write(Identity identity) {
        System.out.println(identity);
        identityRepo.save(identity);
        System.out.println("inserted!!");
    }

    public Identity findById(long id) {
        return identityRepo.findOne(id);
    }
}
