package com.patika.kitapyurdum.repository;

import com.patika.kitapyurdum.model.Cart;
import org.springframework.stereotype.Repository;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class CartRepository {

    private Set<Cart> cartSet = new HashSet<>();

    public void save(Cart cart) {
        cartSet.add(cart);
    }

    public Set<Cart> getAll() {
        return cartSet;
    }

    public Optional<Cart> findById(Long id) {
        return getAll().stream()
                .filter(cart -> cart.getId().equals(id))
                .findFirst();
    }
}
