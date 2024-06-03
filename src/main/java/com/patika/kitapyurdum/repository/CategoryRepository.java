package com.patika.kitapyurdum.repository;

import com.patika.kitapyurdum.model.Category;
import com.patika.kitapyurdum.model.Publisher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    private List<Category> categories = new ArrayList<>();

    public void save(Category category) {
        categories.add(category);
    }

    public List<Category> getAll() {
        return categories;
    }

    public Optional<Category> findById(Long id) {
        return getAll().stream()
                .filter(category -> category.getId().equals(id))
                .findFirst();
    }
}
