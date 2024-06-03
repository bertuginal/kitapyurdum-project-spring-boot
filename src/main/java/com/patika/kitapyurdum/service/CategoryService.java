package com.patika.kitapyurdum.service;

import com.patika.kitapyurdum.converter.CategoryConverter;
import com.patika.kitapyurdum.dto.request.CategorySaveRequest;
import com.patika.kitapyurdum.exception.ExceptionMessages;
import com.patika.kitapyurdum.exception.KitapYurdumException;
import com.patika.kitapyurdum.model.Category;
import com.patika.kitapyurdum.repository.CategoryRepository;
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

        Optional<Category> foundCategory = categoryRepository.findById(request.getId());
        if (foundCategory.isPresent()) {
            log.error(ExceptionMessages.CATEGORY_ALREADY_EXIST);
            throw new KitapYurdumException(ExceptionMessages.CATEGORY_ALREADY_EXIST);
        }

        Category category = CategoryConverter.toCategory(request);

        categoryRepository.save(category);

        log.info("Category saved! {}", category.toString());
    }

    public List<Category> getAllCategories() {
        return categoryRepository.getAll();
    }

    public Category getById(Long id) {
        Optional<Category> foundCategory = categoryRepository.findById(id);

        if (foundCategory.isEmpty()) {
            log.error(ExceptionMessages.CATEGORY_NOT_FOUND);
            throw new KitapYurdumException(ExceptionMessages.CATEGORY_NOT_FOUND);
        }

        return foundCategory.get();
    }

    public Optional<Category> getByName(String categoryName) {
        return getAllCategories().stream()
                .filter(category -> category.getName().equals(categoryName))
                .findFirst();
    }

}
