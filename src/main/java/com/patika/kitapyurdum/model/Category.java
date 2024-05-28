package com.patika.kitapyurdum.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Category {

    private String name;
    private LocalDate createDate;
    private List<Product> productList;
}
