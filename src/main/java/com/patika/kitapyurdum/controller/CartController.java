package com.patika.kitapyurdum.controller;

import com.patika.kitapyurdum.dto.request.CartSaveRequest;
import com.patika.kitapyurdum.dto.response.CartResponse;
import com.patika.kitapyurdum.dto.response.GenericResponse;
import com.patika.kitapyurdum.model.Cart;
import com.patika.kitapyurdum.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CartSaveRequest request) {
        cartService.save(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public GenericResponse<Set<CartResponse>> getAll() {
        return GenericResponse.success(cartService.getAll());
    }

    @GetMapping("/{id}")
    public GenericResponse<Cart> getById(@PathVariable Long id) {

        Cart cart = cartService.getById(id);

        return GenericResponse.success(cart);
    }
}
