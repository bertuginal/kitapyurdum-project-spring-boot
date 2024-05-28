package com.patika.kitapyurdum.repository;

import com.patika.kitapyurdum.model.Author;
import com.patika.kitapyurdum.model.Publisher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository {

    private List<Author> authors = new ArrayList<>();

    public void save(Author author) {
        authors.add(author);
    }

    public List<Author> getAll() {
        return authors;
    }
}
