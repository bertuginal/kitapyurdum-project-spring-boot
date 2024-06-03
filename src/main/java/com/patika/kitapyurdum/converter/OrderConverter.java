package com.patika.kitapyurdum.converter;

import com.patika.kitapyurdum.dto.request.CustomerSaveRequest;
import com.patika.kitapyurdum.dto.request.OrderSaveRequest;
import com.patika.kitapyurdum.dto.request.ProductSaveRequest;
import com.patika.kitapyurdum.dto.response.OrderResponse;
import com.patika.kitapyurdum.dto.response.ProductResponse;
import com.patika.kitapyurdum.model.*;
import com.patika.kitapyurdum.model.enums.AccountType;
import com.patika.kitapyurdum.model.enums.OrderStatus;
import com.patika.kitapyurdum.util.HashUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderConverter {

    public static Order toOrder(OrderSaveRequest request, List<Cart> cartList) {
        String hashedOrderCode = HashUtil.generateOrderCode();
        return Order.builder()
                .id(request.getId())
                .cartList(cartList)
                .orderCode(hashedOrderCode)
                .orderStatus(OrderStatus.INITIAL)
                .createDate(LocalDate.now())
                .build();
    }

    public static OrderResponse toResponse(Order order) {

        return OrderResponse.builder()
                .id(order.getId())
                .cartList(order.getCartList())
                .build();
    }

    public static Set<OrderResponse> toResponse(Set<Order> orders) {
        return  orders
                .stream()
                .map(OrderConverter::toResponse)
                .collect(Collectors.toSet());
    }

}
