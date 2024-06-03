package com.patika.kitapyurdum.service;

import com.patika.kitapyurdum.converter.AuthorConverter;
import com.patika.kitapyurdum.dto.request.AuthorSaveRequest;
import com.patika.kitapyurdum.exception.ExceptionMessages;
import com.patika.kitapyurdum.exception.KitapYurdumException;
import com.patika.kitapyurdum.model.Author;
import com.patika.kitapyurdum.repository.AuthorRepository;
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

        Optional<Author> foundAuthor = authorRepository.findById(request.getId());
        if (foundAuthor.isPresent()) {
            log.error(ExceptionMessages.AUTHOR_ALREADY_EXIST);
            throw new KitapYurdumException(ExceptionMessages.AUTHOR_ALREADY_EXIST);
        }

        Author author = AuthorConverter.toAuthor(request);

        authorRepository.save(author);

        log.info("Author saved! {}", author.toString());
    }

    public List<Author> getAllAuthors() {
        return authorRepository.getAll();
    }

    public Author getById(Long id) {
        Optional<Author> foundAuthor = authorRepository.findById(id);

        if (foundAuthor.isEmpty()) {
            log.error(ExceptionMessages.AUTHOR_NOT_FOUND);
            throw new KitapYurdumException(ExceptionMessages.AUTHOR_NOT_FOUND);
        }

        return foundAuthor.get();
    }

    public Optional<Author> getByName(String authorName) {
        return getAllAuthors().stream()
                .filter(author -> author.getName().equals(authorName))
                .findFirst();
    }

}
