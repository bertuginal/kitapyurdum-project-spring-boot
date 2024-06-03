package com.patika.kitapyurdum.dto.request;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MagazineSaveRequest {

    private Long id;
    private String name;
    private BigDecimal amount;
    private String description;
    private LocalDate createDate;
    private Long publisherId;
    private Long categoryId;
    private Long authorId;
}
