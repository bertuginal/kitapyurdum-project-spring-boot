package com.patika.kitapyurdum.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartSaveRequest {


    private Long id;
    private Long customerId;
    private Long productId;
}
