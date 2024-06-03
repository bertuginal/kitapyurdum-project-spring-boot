package com.patika.kitapyurdum.repository;

import com.patika.kitapyurdum.model.Book;
import com.patika.kitapyurdum.model.Customer;
import com.patika.kitapyurdum.model.Product;
import com.patika.kitapyurdum.model.Publisher;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private Set<Product> productSet = new HashSet<>();
    private List<Product> productList = new ArrayList<>();

    public void save(Product product) {
        productSet.add(product);
    }

    public Set<Product> getAll() {
        return productSet;
    }

    public Optional<Product> findById(Long id) {
        return getAll().stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }
    public List<Book> findAllBooks() {
        return productList.stream()
                .filter(product -> product instanceof Book)
                .map(product -> (Book) product)
                .collect(Collectors.toList());
    }
}
