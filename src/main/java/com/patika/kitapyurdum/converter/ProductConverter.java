package com.patika.kitapyurdum.converter;

import com.patika.kitapyurdum.dto.request.ProductSaveRequest;
import com.patika.kitapyurdum.dto.response.ProductResponse;
import com.patika.kitapyurdum.model.Book;
import com.patika.kitapyurdum.model.Category;
import com.patika.kitapyurdum.model.Product;
import com.patika.kitapyurdum.model.Publisher;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductConverter {

    public static Product toProduct(ProductSaveRequest request, Publisher publisher, Category category) {
        return Product.builder()
                .id(request.getId())
                .name(request.getName())
                .amount(request.getAmount())
                .description(request.getDescription())
                .createDate(LocalDate.now())
                .publisher(publisher)
                .category(category)
                .build();

    }

    public static ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .amount(product.getAmount())
                .name(product.getName())
                .description(product.getDescription())
                .publisherId(product.getPublisher().getId())
                .categoryId(product.getCategory().getId())
                .build();
    }

    public static Set<ProductResponse> toResponse(Set<Product> products) {
        return products
                .stream()
                .map(ProductConverter::toResponse)
                .collect(Collectors.toSet());
    }

}
