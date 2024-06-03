package com.patika.kitapyurdum.controller;

import com.patika.kitapyurdum.dto.request.BookSaveRequest;
import com.patika.kitapyurdum.dto.request.MagazineSaveRequest;
import com.patika.kitapyurdum.model.Author;
import com.patika.kitapyurdum.model.Category;
import com.patika.kitapyurdum.model.Publisher;
import com.patika.kitapyurdum.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/magazines")
public class MagazineController {


    private final MagazineService magazineService;
    private final PublisherService publisherService;
    private final CategoryService categoryService;
    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<MagazineSaveRequest> save(@RequestBody MagazineSaveRequest request) {
        Publisher publisher = publisherService.getById(request.getPublisherId());
        Category category = categoryService.getById(request.getCategoryId());
        Author author = authorService.getById(request.getAuthorId());

        MagazineSaveRequest createdMagazine = magazineService.save(request, publisher, category, author);
        return new ResponseEntity<>(createdMagazine, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MagazineSaveRequest> getMagazineById(@PathVariable Long id) {
        MagazineSaveRequest request = magazineService.getMagazineById(id);
        return request != null ? ResponseEntity.ok(request) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<MagazineSaveRequest>> getAllBooks() {
        List<MagazineSaveRequest> magazines = magazineService.getAllMagazine();
        return ResponseEntity.ok(magazineService.getAllMagazine());
    }
}
