package com.patika.kitapyurdum.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerUpdateRequest {

    private String email;
    private Long addressId;
}
