package com.patika.kitapyurdum.converter;

import com.patika.kitapyurdum.dto.request.CartSaveRequest;
import com.patika.kitapyurdum.dto.response.CartResponse;
import com.patika.kitapyurdum.model.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CartConverter {

    public static Cart toCart(CartSaveRequest request, Customer customer, Product product) {
        return Cart.builder()
                .id(request.getId())
                .createDate(LocalDate.now())
                .customer(customer)
                .product(product)
                .build();
    }

    public static CartResponse toResponse(Cart cart) {
        return CartResponse.builder()
                .id(cart.getId())
                .customerId(cart.getCustomer().getId())
                .productId(cart.getProduct().getId())
                .build();
    }

    public static Set<CartResponse> toResponse(Set<Cart> carts) {
        return carts
                .stream()
                .map(CartConverter::toResponse)
                .collect(Collectors.toSet());
    }
}
