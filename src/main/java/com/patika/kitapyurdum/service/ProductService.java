package com.patika.kitapyurdum.service;

import com.patika.kitapyurdum.converter.ProductConverter;
import com.patika.kitapyurdum.dto.request.ProductSaveRequest;
import com.patika.kitapyurdum.dto.response.ProductResponse;
import com.patika.kitapyurdum.model.Category;
import com.patika.kitapyurdum.model.Product;
import com.patika.kitapyurdum.model.Publisher;
import com.patika.kitapyurdum.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final PublisherService publisherService;
    private final CategoryService categoryService;

    public void save(ProductSaveRequest request) {

        Optional<Publisher> optionalPublisher = publisherService.getByName(request.getPublisherName());
        Optional<Category> optionalCategory = categoryService.getByName(request.getCategoryName());

        if (optionalPublisher.isEmpty()) {
            log.error("Publisher not found! : {}", request.getPublisherName());
            throw new RuntimeException("Publisher not found!");
        }
        if (optionalCategory.isEmpty()) {
            log.error("Category not found! : {}", request.getCategoryName());
            throw new RuntimeException("Category not found!");
        }

        Product product = ProductConverter.toProduct(request, optionalPublisher.get(), optionalCategory.get());

        productRepository.save(product);

        log.info("Product created! : {}", product.toString());
    }

    public Set<ProductResponse> getAll() {
        return ProductConverter.toResponse(productRepository.getAll());
    }

}
