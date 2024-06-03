package com.patika.kitapyurdum.repository;

import com.patika.kitapyurdum.model.Book;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookRepository {

    private List<Book> books = new ArrayList<>();
    private long nextId = 1L;

    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(nextId++);
            books.add(book);
        } else {
            books = books.stream()
                    .map(b -> b.getId().equals(book.getId()) ? book : b)
                    .collect(Collectors.toList());
        }
        return book;
    }

    public Book findById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Book> findAll() {
        return new ArrayList<>(books);
    }


}