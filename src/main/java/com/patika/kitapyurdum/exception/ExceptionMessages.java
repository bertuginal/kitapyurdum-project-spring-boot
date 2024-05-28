package com.patika.kitapyurdum.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessages {
    
    public static final String CUSTOMER_NOT_FOUND = "Customer not found!";
    public static final String CUSTOMER_NOT_ACTIVE = "Customer is not active!";
    public static final String EMAIL_ALREADY_EXIST = "There is a user registered with this email!";
    public static final String PUBLISHER_NOT_FOUND = "Publisher not found!";
}
