package com.patika.kitapyurdum.dto.response;

import com.patika.kitapyurdum.model.Cart;
import lombok.*;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {

    private Long id;
    private List<Cart> cartList;
}
