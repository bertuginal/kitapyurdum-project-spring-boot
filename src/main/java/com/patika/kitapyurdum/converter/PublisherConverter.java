package com.patika.kitapyurdum.converter;

import com.patika.kitapyurdum.dto.request.PublisherSaveRequest;
import com.patika.kitapyurdum.model.Publisher;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PublisherConverter {

    public static Publisher toPublisher(PublisherSaveRequest request) {
        return Publisher.builder()
                .id(request.getId())
                .name(request.getName())
                .createDate(LocalDate.now())
                .build();
    }
}
