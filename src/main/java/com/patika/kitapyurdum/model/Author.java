package com.patika.kitapyurdum.model;


import lombok.*;

import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Author {


    private Long Id;
    private String name;
    private String surname;
    private String biography;
    private Set<Book> books;

}
