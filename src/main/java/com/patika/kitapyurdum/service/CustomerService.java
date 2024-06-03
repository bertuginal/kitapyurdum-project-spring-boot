package com.patika.kitapyurdum.service;

import com.patika.kitapyurdum.converter.CustomerConverter;
import com.patika.kitapyurdum.dto.request.CustomerSaveRequest;
import com.patika.kitapyurdum.dto.request.CustomerUpdateRequest;
import com.patika.kitapyurdum.exception.ExceptionMessages;
import com.patika.kitapyurdum.exception.KitapYurdumException;
import com.patika.kitapyurdum.model.Address;
import com.patika.kitapyurdum.model.Customer;
import com.patika.kitapyurdum.model.enums.AccountType;
import com.patika.kitapyurdum.repository.AddressRepository;
import com.patika.kitapyurdum.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressService addressService;

    public void save(CustomerSaveRequest request) throws NoSuchAlgorithmException {

        Optional<Customer> foundCustomerEmail = customerRepository.findByEmail(request.getEmail());
        Optional<Customer> foundCustomerId = customerRepository.findById(request.getId());
        Address address = addressService.getById(request.getAddressId());

        if (foundCustomerId.isPresent()) {
            log.error(ExceptionMessages.CUSTOMER_ALREADY_EXIST);
            throw new KitapYurdumException(ExceptionMessages.CUSTOMER_ALREADY_EXIST);
        }


        if (foundCustomerEmail.isPresent()) {
            log.error(ExceptionMessages.EMAIL_ALREADY_EXIST);
            throw new KitapYurdumException(ExceptionMessages.EMAIL_ALREADY_EXIST);
        }

        Customer customer = CustomerConverter.toCustomer(request, address);

        customerRepository.createCustomer(customer);

        log.info("Customer saved! {}", customer.getEmail());
    }

    public Customer update(Long id, CustomerUpdateRequest request) {

        Optional<Customer> foundCustomer = customerRepository.findById(id);
        Address address = addressService.getById(request.getAddressId());

        if (foundCustomer.isPresent()) {
            Customer customer = CustomerConverter.toUpdate(request, address);
            log.info("Customer updated! {}", customer.getEmail() + address.toString());
            customerRepository.update(customer);
            return customer;
        }
        else {
            throw new KitapYurdumException(ExceptionMessages.CUSTOMER_NOT_FOUND);
        }
    }

    public List<Customer> getCustomerList() {
        return customerRepository.getCustomerList();
    }


    public Customer getById(Long id) {
        Optional<Customer> foundCustomer = customerRepository.findById(id);

        if (foundCustomer.isEmpty()) {
            log.error(ExceptionMessages.CUSTOMER_NOT_FOUND);
            throw new KitapYurdumException(ExceptionMessages.CUSTOMER_NOT_FOUND);
        }

        return foundCustomer.get();
    }

    public Customer getByEmail(String email) {

        Optional<Customer> foundCustomer = customerRepository.findByEmail(email);

        if (!foundCustomer.get().getIsActive()) {
            log.error(ExceptionMessages.CUSTOMER_NOT_ACTIVE);
            throw new KitapYurdumException(ExceptionMessages.CUSTOMER_NOT_ACTIVE);
        }

        return foundCustomer.get();
    }

    public void changeAccountType(CustomerSaveRequest request, AccountType accountType) {

        Optional<Customer> foundCustomer = getCustomerList()
                .stream()
                .filter(customer -> customer.getEmail().equals(request.getEmail()))
                .findFirst();

        if (foundCustomer.isPresent()) {
            foundCustomer.get().setAccountType(accountType);
        }
    }

    public void changeAccountTypeByCredit(CustomerSaveRequest request) {
        Optional<Customer> findCustomer = getCustomerList()
                .stream()
                .filter(customer -> customer.getEmail().equals(request.getEmail()))
                .findFirst();

        if (findCustomer.isPresent()) {
            if (request.getCredit() >= 1000 && request.getCredit() <= 1999) { findCustomer.get().setAccountType(AccountType.SILVER); }
            else if (request.getCredit() >= 2000 && request.getCredit() <=3999) { findCustomer.get().setAccountType(AccountType.GOLD); }
            else if (request.getCredit() >= 4000) { findCustomer.get().setAccountType(AccountType.PLATINUM); }
            else { findCustomer.get().setAccountType(AccountType.STANDARD); }
        }
    }
}
