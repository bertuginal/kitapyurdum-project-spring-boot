package com.patika.kitapyurdum.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartResponse {

    private Long id;
    private Long customerId;
    private Long productId;
}
