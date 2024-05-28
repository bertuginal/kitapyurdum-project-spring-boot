package com.patika.kitapyurdum.service;

import com.patika.kitapyurdum.converter.AuthorConverter;
import com.patika.kitapyurdum.converter.PublisherConverter;
import com.patika.kitapyurdum.dto.request.AuthorSaveRequest;
import com.patika.kitapyurdum.dto.request.PublisherSaveRequest;
import com.patika.kitapyurdum.model.Author;
import com.patika.kitapyurdum.model.Publisher;
import com.patika.kitapyurdum.repository.AuthorRepository;
import com.patika.kitapyurdum.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuthorService {

    private final AuthorRepository authorRepository;

    public void save(AuthorSaveRequest request) {

        Author author = AuthorConverter.toAuthor(request);

        authorRepository.save(author);

        log.info("Author saved! {}", author.toString());
    }

    public List<Author> getAllAuthors() {
        return authorRepository.getAll();
    }

    public Optional<Author> getByName(String authorName) {
        return getAllAuthors().stream()
                .filter(author -> author.getName().equals(authorName))
                .findFirst();
    }
}
