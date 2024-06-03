package com.patika.kitapyurdum.converter;

import com.patika.kitapyurdum.dto.request.CustomerSaveRequest;
import com.patika.kitapyurdum.dto.request.CustomerUpdateRequest;
import com.patika.kitapyurdum.model.*;
import com.patika.kitapyurdum.model.enums.AccountType;
import com.patika.kitapyurdum.service.CustomerService;
import com.patika.kitapyurdum.util.HashUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerConverter {

    public static Customer toCustomer(CustomerSaveRequest request, Address address) throws NoSuchAlgorithmException {
        String hashedPassword = HashUtil.hashPassword(request.getPassword());

        Customer customer = new Customer(request.getId(), request.getName(), request.getSurname(), request.getEmail(), hashedPassword, address);
        customer.setAddress(address);
        customer.setAccountType(AccountType.STANDARD);
        customer.setIsActive(Boolean.TRUE);
        return customer;
    }

    public static Customer toUpdate(CustomerUpdateRequest request, Address address) {
        return Customer.builder()
                .email(request.getEmail())
                .address(address)
                .build();
    }


}
