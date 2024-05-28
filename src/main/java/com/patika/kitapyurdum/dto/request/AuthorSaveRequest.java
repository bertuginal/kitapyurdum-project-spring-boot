package com.patika.kitapyurdum.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorSaveRequest {

    private String name;
    private String surname;
    private String biography;
}
