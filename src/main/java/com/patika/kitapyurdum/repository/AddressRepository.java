package com.patika.kitapyurdum.repository;

import com.patika.kitapyurdum.model.Address;
import com.patika.kitapyurdum.model.Publisher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AddressRepository {

    private List<Address> addresses = new ArrayList<>();

    public void save(Address address) {
        addresses.add(address);
    }

    public List<Address> getAll() {
        return addresses;
    }

    public Optional<Address> findById(Long id) {
        return getAll().stream()
                .filter(address -> address.getId().equals(id))
                .findFirst();
    }
}
