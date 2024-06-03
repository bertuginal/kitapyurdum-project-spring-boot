package com.patika.kitapyurdum.controller;

import com.patika.kitapyurdum.dto.request.OrderSaveRequest;
import com.patika.kitapyurdum.dto.request.ProductSaveRequest;
import com.patika.kitapyurdum.dto.response.GenericResponse;
import com.patika.kitapyurdum.dto.response.OrderResponse;
import com.patika.kitapyurdum.dto.response.ProductResponse;
import com.patika.kitapyurdum.model.Order;
import com.patika.kitapyurdum.model.Product;
import com.patika.kitapyurdum.service.OrderService;
import com.patika.kitapyurdum.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody OrderSaveRequest request) {
        orderService.save(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public GenericResponse<Set<OrderResponse>> getAll() {
        return GenericResponse.success(orderService.getAll());
    }

    @GetMapping("/{id}")
    public GenericResponse<Order> getById(@PathVariable Long id) {

        Order order = orderService.getById(id);

        return GenericResponse.success(order);
    }
}
