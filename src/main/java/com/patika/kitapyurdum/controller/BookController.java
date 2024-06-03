package com.patika.kitapyurdum.controller;

import com.patika.kitapyurdum.dto.request.BookSaveRequest;
import com.patika.kitapyurdum.model.Author;
import com.patika.kitapyurdum.model.Category;
import com.patika.kitapyurdum.model.Publisher;
import com.patika.kitapyurdum.service.AuthorService;
import com.patika.kitapyurdum.service.BookService;
import com.patika.kitapyurdum.service.CategoryService;
import com.patika.kitapyurdum.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;
    private final PublisherService publisherService;
    private final CategoryService categoryService;
    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<BookSaveRequest> save(@RequestBody BookSaveRequest request) {
        Publisher publisher = publisherService.getById(request.getPublisherId());
        Category category = categoryService.getById(request.getCategoryId());
        Author author = authorService.getById(request.getAuthorId());

        BookSaveRequest createdBook = bookService.save(request, publisher, category, author);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookSaveRequest> getBookById(@PathVariable Long id) {
        BookSaveRequest request = bookService.getBookById(id);
        return request != null ? ResponseEntity.ok(request) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<BookSaveRequest>> getAllBooks() {
        List<BookSaveRequest> books = bookService.getAllBooks();
        return ResponseEntity.ok(bookService.getAllBooks());
    }


}