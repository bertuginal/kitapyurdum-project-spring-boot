package com.patika.kitapyurdum.controller;

import com.patika.kitapyurdum.dto.request.AddressSaveRequest;
import com.patika.kitapyurdum.dto.request.PublisherSaveRequest;
import com.patika.kitapyurdum.dto.response.GenericResponse;
import com.patika.kitapyurdum.model.Address;
import com.patika.kitapyurdum.model.Publisher;
import com.patika.kitapyurdum.service.AddressService;
import com.patika.kitapyurdum.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody AddressSaveRequest request) {
        addressService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<Address> getAll() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public GenericResponse<Address> getById(@PathVariable Long id) {

        Address address = addressService.getById(id);

        return GenericResponse.success(address);
    }
}
