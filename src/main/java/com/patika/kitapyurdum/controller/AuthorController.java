package com.patika.kitapyurdum.controller;

import com.patika.kitapyurdum.dto.request.AuthorSaveRequest;
import com.patika.kitapyurdum.dto.request.PublisherSaveRequest;
import com.patika.kitapyurdum.model.Author;
import com.patika.kitapyurdum.model.Publisher;
import com.patika.kitapyurdum.service.AuthorService;
import com.patika.kitapyurdum.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody AuthorSaveRequest request) {
        authorService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<Author> getAll() {
        return authorService.getAllAuthors();
    }
}
