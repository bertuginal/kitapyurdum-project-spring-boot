package com.patika.kitapyurdum.converter;

import com.patika.kitapyurdum.dto.request.AuthorSaveRequest;
import com.patika.kitapyurdum.model.Author;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorConverter {
    public static Author toAuthor(AuthorSaveRequest request) {
        return Author.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .biography(request.getBiography())
                .build();
    }
}
