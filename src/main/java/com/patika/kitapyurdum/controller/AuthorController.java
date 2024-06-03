package com.patika.kitapyurdum.controller;

import com.patika.kitapyurdum.dto.request.AuthorSaveRequest;
import com.patika.kitapyurdum.dto.response.GenericResponse;
import com.patika.kitapyurdum.model.Author;
import com.patika.kitapyurdum.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public GenericResponse<Author> getById(@PathVariable Long id) {

        Author author = authorService.getById(id);

        return GenericResponse.success(author);
    }

    @GetMapping("/name/{name}")
    public GenericResponse<Optional<Author>> getByName(@PathVariable String name) {
        Optional<Author> author = authorService.getByName(name);
        return GenericResponse.success(author);
    }
}
