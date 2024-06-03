package com.patika.kitapyurdum.dto.request;

import com.patika.kitapyurdum.model.Customer;
import com.patika.kitapyurdum.model.Product;
import com.patika.kitapyurdum.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderSaveRequest {

    private Long id;
    private Long cartId;

}
