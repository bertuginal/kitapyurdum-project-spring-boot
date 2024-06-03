package com.patika.kitapyurdum.converter;

import com.patika.kitapyurdum.dto.request.BookSaveRequest;
import com.patika.kitapyurdum.dto.response.BookResponse;
import com.patika.kitapyurdum.model.Author;
import com.patika.kitapyurdum.model.Book;
import com.patika.kitapyurdum.model.Category;
import com.patika.kitapyurdum.model.Publisher;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConverter {

    public BookSaveRequest toBook(Book book) {
        return new BookSaveRequest(
                book.getId(),
                book.getName(),
                book.getAmount(),
                book.getDescription(),
                book.getCreateDate(),
                book.getPublisher().getId(),
                book.getCategory().getId(),
                book.getAuthor().getId()
        );
    }

    public Book convertToEntity(BookSaveRequest request, Publisher publisher, Category category, Author author) {
        return new Book(
                request.getId(),
                request.getName(),
                request.getAmount(),
                request.getDescription(),
                request.getCreateDate(),
                publisher,
                category,
                author
        );
    }



}