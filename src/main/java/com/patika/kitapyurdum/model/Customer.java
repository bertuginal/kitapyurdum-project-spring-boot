package com.patika.kitapyurdum.model;


import com.patika.kitapyurdum.model.enums.AccountType;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class Customer {


    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Integer credit;
    private String phoneNumber;
    private Address address;
    private Boolean isActive;
    private AccountType accountType;

    public Customer(Long id, String name, String surname, String email, String password, Address address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.address = address;
    }

}
