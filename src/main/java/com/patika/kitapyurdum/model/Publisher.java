package com.patika.kitapyurdum.model;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Publisher {

    private Long id;
    private String name;
    private LocalDate createDate;
    //private List<Book> bookList; //model olarak bunu yapmadık.

}
