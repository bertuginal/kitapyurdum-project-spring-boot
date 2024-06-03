package com.patika.kitapyurdum.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorSaveRequest {

    private Long id;
    private String name;
    private String surname;
    private String biography;
}
