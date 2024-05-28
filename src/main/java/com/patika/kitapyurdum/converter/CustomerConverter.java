package com.patika.kitapyurdum.converter;

import com.patika.kitapyurdum.dto.request.CustomerSaveRequest;
import com.patika.kitapyurdum.model.Customer;
import com.patika.kitapyurdum.model.enums.AccountType;
import com.patika.kitapyurdum.util.HashUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.NoSuchAlgorithmException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerConverter {
    public static Customer toCustomer(CustomerSaveRequest request) throws NoSuchAlgorithmException {
        String hashedPassword = HashUtil.hashPassword(request.getPassword());

        Customer customer = new Customer(request.getName(), request.getSurname(), request.getEmail(), hashedPassword);
        customer.setAccountType(AccountType.STANDARD);
        customer.setIsActive(Boolean.TRUE);
        return customer;
    }
}
