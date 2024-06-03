package com.patika.kitapyurdum.model;

import com.patika.kitapyurdum.model.enums.OrderStatus;
import com.patika.kitapyurdum.service.CustomerService;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Order {


    private Long id;
    private LocalDate createDate;
    private String orderCode;
    private OrderStatus orderStatus;
    private List<Cart> cartList;


    public Order(Long id, List<Cart> cartList) {
        this.id = id;
        this.cartList = cartList;

    }
}
