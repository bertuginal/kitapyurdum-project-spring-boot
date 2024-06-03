package com.patika.kitapyurdum.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {


    private Long id;
    private String name;
    private BigDecimal amount;
    private String description;
    private Long publisherId;
    private Long categoryId;
    private Long authorId;
}
