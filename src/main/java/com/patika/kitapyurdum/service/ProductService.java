package com.patika.kitapyurdum.service;

import com.patika.kitapyurdum.converter.ProductConverter;
import com.patika.kitapyurdum.dto.request.BookSaveRequest;
import com.patika.kitapyurdum.dto.request.ProductSaveRequest;
import com.patika.kitapyurdum.dto.response.ProductResponse;
import com.patika.kitapyurdum.exception.ExceptionMessages;
import com.patika.kitapyurdum.exception.KitapYurdumException;
import com.patika.kitapyurdum.model.Book;
import com.patika.kitapyurdum.model.Category;
import com.patika.kitapyurdum.model.Product;
import com.patika.kitapyurdum.model.Publisher;
import com.patika.kitapyurdum.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
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

        Publisher publisher = publisherService.getById(request.getPublisherId());
        Category category = categoryService.getById(request.getCategoryId());


        Optional<Product> foundProduct = productRepository.findById(request.getId());
        if (foundProduct.isPresent()) {
            log.error(ExceptionMessages.PRODUCT_ALREADY_EXIST);
            throw new KitapYurdumException(ExceptionMessages.PRODUCT_ALREADY_EXIST);
        }

        Product product = ProductConverter.toProduct(request, publisher, category);

        productRepository.save(product);

        log.info("Product saved! : {}", product.toString());
    }

    public Set<ProductResponse> getAll() {
        return ProductConverter.toResponse(productRepository.getAll());
    }

    public Product getById(Long id) {
        Optional<Product> foundProduct = productRepository.findById(id);

        if (foundProduct.isEmpty()) {
            log.error(ExceptionMessages.PRODUCT_NOT_FOUND);
            throw new KitapYurdumException(ExceptionMessages.PRODUCT_NOT_FOUND);
        }

        return foundProduct.get();
    }
}
