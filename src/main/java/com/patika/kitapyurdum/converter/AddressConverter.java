package com.patika.kitapyurdum.converter;

import com.patika.kitapyurdum.dto.request.AddressSaveRequest;
import com.patika.kitapyurdum.model.Address;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressConverter {

    public static Address toAddress(AddressSaveRequest request) {
        return Address.builder()
                .title(request.getTitle())
                .province(request.getProvince())
                .description(request.getDescription())
                .build();
    }
}
