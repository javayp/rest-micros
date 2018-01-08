package com.usr.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    private long cellNumber;

    private String firstName;

    private String lastName;

    private String address1;

    private String address2;

    private String passportNumber;

}
