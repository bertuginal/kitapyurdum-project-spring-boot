package com.patika.kitapyurdum.controller;

import com.patika.kitapyurdum.dto.request.CategorySaveRequest;
import com.patika.kitapyurdum.dto.response.GenericResponse;
import com.patika.kitapyurdum.model.Category;
import com.patika.kitapyurdum.model.Publisher;
import com.patika.kitapyurdum.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CategorySaveRequest request) {
        categoryService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public GenericResponse<Category> getById(@PathVariable Long id) {

        Category category = categoryService.getById(id);

        return GenericResponse.success(category);
    }

    @GetMapping("/name/{name}")
    public GenericResponse<Optional<Category>> getByName(@PathVariable String name) {
        Optional<Category> category = categoryService.getByName(name);
        return GenericResponse.success(category);
    }
}
