package com.patika.kitapyurdum.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book extends Product {

    private Author author;

    public Book(String name, BigDecimal amount, String description, LocalDate createDate, Publisher publisher, Category category, Author author) {
        super(name, amount, description, createDate, publisher, category);
        this.author = author;
    }

}
