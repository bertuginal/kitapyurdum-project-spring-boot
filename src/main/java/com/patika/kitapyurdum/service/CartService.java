package com.patika.kitapyurdum.service;

import com.patika.kitapyurdum.converter.CartConverter;
import com.patika.kitapyurdum.dto.request.CartSaveRequest;
import com.patika.kitapyurdum.dto.response.CartResponse;
import com.patika.kitapyurdum.exception.ExceptionMessages;
import com.patika.kitapyurdum.exception.KitapYurdumException;
import com.patika.kitapyurdum.model.Cart;
import com.patika.kitapyurdum.model.Customer;
import com.patika.kitapyurdum.model.Product;
import com.patika.kitapyurdum.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {

    private final CartRepository cartRepository;
    private final CustomerService customerService;
    private final ProductService productService;

    public void save(CartSaveRequest request) {

        Customer customer = customerService.getById(request.getCustomerId());
        Product product = productService.getById(request.getProductId());

        Optional<Cart> foundCart = cartRepository.findById(request.getId());
        if (foundCart.isPresent()) {
            log.error(ExceptionMessages.CART_ALREADY_EXIST);
            throw new KitapYurdumException(ExceptionMessages.CART_ALREADY_EXIST);
        }

        Cart cart = CartConverter.toCart(request, customer, product);

        cartRepository.save(cart);

        log.info("Cart saved! : {}", cart.toString());
    }

    public Set<CartResponse> getAll() {
        return CartConverter.toResponse(cartRepository.getAll());
    }

    public Cart getById(Long id) {
        Optional<Cart> foundCart = cartRepository.findById(id);

        if (foundCart.isEmpty()) {
            log.error(ExceptionMessages.CART_NOT_FOUND);
            throw new KitapYurdumException(ExceptionMessages.CART_NOT_FOUND);
        }

        return foundCart.get();
    }
}
