package com.patika.kitapyurdum.service;

import com.patika.kitapyurdum.converter.BookConverter;
import com.patika.kitapyurdum.dto.request.BookSaveRequest;
import com.patika.kitapyurdum.dto.response.BookResponse;
import com.patika.kitapyurdum.model.Author;
import com.patika.kitapyurdum.model.Book;
import com.patika.kitapyurdum.model.Category;
import com.patika.kitapyurdum.model.Publisher;
import com.patika.kitapyurdum.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
@Slf4j
public class BookService {

    private final BookRepository bookRepository;
    private final BookConverter bookConverter;

    public BookSaveRequest save(BookSaveRequest request, Publisher publisher, Category category, Author author) {
        Book book = bookConverter.convertToEntity(request, publisher, category, author);
        book = bookRepository.save(book);
        log.info("Book saved! : {}", book.toString());
        return bookConverter.toBook(book);
    }

    public BookSaveRequest getBookById(Long id) {
        Book book = bookRepository.findById(id);
        return book != null ? bookConverter.toBook(book) : null;
    }

    public List<BookSaveRequest> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(bookConverter::toBook)
                .collect(Collectors.toList());
    }


}