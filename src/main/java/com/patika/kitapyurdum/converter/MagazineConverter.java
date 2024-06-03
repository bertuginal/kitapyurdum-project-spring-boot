package com.patika.kitapyurdum.converter;

import com.patika.kitapyurdum.dto.request.BookSaveRequest;
import com.patika.kitapyurdum.dto.request.MagazineSaveRequest;
import com.patika.kitapyurdum.model.*;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MagazineConverter {

    public MagazineSaveRequest toMagazine(Magazine magazine) {
        return new MagazineSaveRequest(
                magazine.getId(),
                magazine.getName(),
                magazine.getAmount(),
                magazine.getDescription(),
                magazine.getCreateDate(),
                magazine.getPublisher().getId(),
                magazine.getCategory().getId(),
                magazine.getAuthor().getId()
        );
    }

    public Magazine convertToEntity(MagazineSaveRequest request, Publisher publisher, Category category, Author author) {
        return new Magazine(
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
