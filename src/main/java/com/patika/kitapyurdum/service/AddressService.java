package com.patika.kitapyurdum.service;

import com.patika.kitapyurdum.converter.AddressConverter;
import com.patika.kitapyurdum.converter.CustomerConverter;
import com.patika.kitapyurdum.converter.PublisherConverter;
import com.patika.kitapyurdum.dto.request.AddressSaveRequest;
import com.patika.kitapyurdum.dto.request.CustomerSaveRequest;
import com.patika.kitapyurdum.dto.request.PublisherSaveRequest;
import com.patika.kitapyurdum.exception.ExceptionMessages;
import com.patika.kitapyurdum.exception.KitapYurdumException;
import com.patika.kitapyurdum.model.Address;
import com.patika.kitapyurdum.model.Customer;
import com.patika.kitapyurdum.model.Publisher;
import com.patika.kitapyurdum.repository.AddressRepository;
import com.patika.kitapyurdum.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressService {

    private final AddressRepository addressRepository;

    public void save(AddressSaveRequest request) {

        Address address = AddressConverter.toAddress(request);

        addressRepository.save(address);

        log.info("Address saved! {}", address.toString());
    }

    public List<Address> getAllAddresses() {
        return addressRepository.getAll();
    }
}
