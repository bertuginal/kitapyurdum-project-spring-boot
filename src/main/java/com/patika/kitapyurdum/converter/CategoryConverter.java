package com.patika.kitapyurdum.converter;

import com.patika.kitapyurdum.dto.request.CategorySaveRequest;
import com.patika.kitapyurdum.model.Category;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryConverter {

    public static Category toCategory(CategorySaveRequest request) {
        return Category.builder()
                .name(request.getName())
                .createDate(LocalDate.now())
                .build();

    }
}
