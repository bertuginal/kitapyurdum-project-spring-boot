package com.patika.kitapyurdum.controller;

import com.patika.kitapyurdum.dto.request.BookSaveRequest;
import com.patika.kitapyurdum.dto.request.ProductSaveRequest;
import com.patika.kitapyurdum.dto.request.PublisherSaveRequest;
import com.patika.kitapyurdum.dto.response.GenericResponse;
import com.patika.kitapyurdum.dto.response.ProductResponse;
import com.patika.kitapyurdum.model.Book;
import com.patika.kitapyurdum.model.Product;
import com.patika.kitapyurdum.model.Publisher;
import com.patika.kitapyurdum.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ProductSaveRequest request) {
        productService.save(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public GenericResponse<Set<ProductResponse>> getAll() {
        return GenericResponse.success(productService.getAll());
    }

    @GetMapping("/{id}")
    public GenericResponse<Product> getById(@PathVariable Long id) {

        Product product = productService.getById(id);

        return GenericResponse.success(product);
    }


}
