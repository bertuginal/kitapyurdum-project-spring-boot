package com.patika.kitapyurdum.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSaveRequest {

    private Long id;
    private String name;
    private BigDecimal amount;
    private String description;
    private Long publisherId;
    private Long categoryId;
}
