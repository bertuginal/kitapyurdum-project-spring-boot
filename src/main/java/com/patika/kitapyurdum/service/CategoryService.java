package com.patika.kitapyurdum.service;

import com.patika.kitapyurdum.converter.CategoryConverter;
import com.patika.kitapyurdum.converter.PublisherConverter;
import com.patika.kitapyurdum.dto.request.CategorySaveRequest;
import com.patika.kitapyurdum.dto.request.PublisherSaveRequest;
import com.patika.kitapyurdum.model.Category;
import com.patika.kitapyurdum.model.Publisher;
import com.patika.kitapyurdum.repository.CategoryRepository;
import com.patika.kitapyurdum.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class CategoryService {


    private final CategoryRepository categoryRepository;

    public void save(CategorySaveRequest request) {

        Category category = CategoryConverter.toCategory(request);

        categoryRepository.save(category);

        log.info("Category saved! {}", category.toString());
    }

    public List<Category> getAllCategories() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getByName(String categoryName) {
        return getAllCategories().stream()
                .filter(category -> category.getName().equals(categoryName))
                .findFirst();
    }
}
