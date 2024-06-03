package com.patika.kitapyurdum.repository;

import com.patika.kitapyurdum.model.Customer;
import com.patika.kitapyurdum.model.Order;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepository {

    Set<Order> orderList = new HashSet<>();

    public void save(Order order) { orderList.add(order); }

    public Set<Order> getAll(){ return orderList; }


    public Optional<Order> findById(Long id) {
        return getAll().stream()
                .filter(order -> order.getId().equals(id))
                .findFirst();
    }

}
