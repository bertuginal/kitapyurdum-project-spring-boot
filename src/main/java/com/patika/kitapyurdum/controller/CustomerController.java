package com.patika.kitapyurdum.controller;

import com.patika.kitapyurdum.dto.request.CustomerSaveRequest;
import com.patika.kitapyurdum.dto.request.CustomerUpdateRequest;
import com.patika.kitapyurdum.dto.response.GenericResponse;
import com.patika.kitapyurdum.model.Address;
import com.patika.kitapyurdum.model.Customer;
import com.patika.kitapyurdum.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void save(@RequestBody CustomerSaveRequest request) throws NoSuchAlgorithmException {
        customerService.save(request);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable @RequestBody Long id, CustomerUpdateRequest request) {
       return customerService.update(id, request);

    }

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getCustomerList();
    }

    @GetMapping("/{id}")
    public GenericResponse<Customer> getById(@PathVariable Long id) {

        Customer customer = customerService.getById(id);

        return GenericResponse.success(customer);
    }

    @GetMapping("/email/{email}")
    public GenericResponse<Customer> getByEmail(@PathVariable String email) {
        Customer customer = customerService.getByEmail(email);
        return GenericResponse.success(customer);
    }


}
