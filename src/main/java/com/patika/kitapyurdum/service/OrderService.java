package com.patika.kitapyurdum.service;

import com.patika.kitapyurdum.converter.OrderConverter;
import com.patika.kitapyurdum.converter.ProductConverter;
import com.patika.kitapyurdum.dto.request.CartSaveRequest;
import com.patika.kitapyurdum.dto.request.OrderSaveRequest;
import com.patika.kitapyurdum.dto.request.ProductSaveRequest;
import com.patika.kitapyurdum.dto.response.OrderResponse;
import com.patika.kitapyurdum.dto.response.ProductResponse;
import com.patika.kitapyurdum.exception.ExceptionMessages;
import com.patika.kitapyurdum.exception.KitapYurdumException;
import com.patika.kitapyurdum.model.*;
import com.patika.kitapyurdum.repository.OrderRepository;
import com.patika.kitapyurdum.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartService cartService;


    public void save(OrderSaveRequest request) {

        List<Cart> cartList = new ArrayList<>();
        Cart cart = cartService.getById(request.getId());

        Optional<Order> foundOrder = orderRepository.findById(request.getId());
        if (foundOrder.isPresent()) {
            log.error(ExceptionMessages.ORDER_ALREADY_EXIST);
            throw new KitapYurdumException(ExceptionMessages.ORDER_ALREADY_EXIST);
        }

        cartList.add(cart);


            Order order = OrderConverter.toOrder(request, cartList);
            orderRepository.save(order);

            log.info("Order saved! : {}", order.toString());

    }

    public Set<OrderResponse> getAll() {
        return OrderConverter.toResponse(orderRepository.getAll());
    }

    public Order getById(Long id) {
        Optional<Order> foundOrder = orderRepository.findById(id);

        if (foundOrder.isEmpty()) {
            log.error(ExceptionMessages.ORDER_NOT_FOUND);
            throw new KitapYurdumException(ExceptionMessages.ORDER_NOT_FOUND);
        }

        return foundOrder.get();
    }

}
