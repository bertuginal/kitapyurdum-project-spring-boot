package com.patika.kitapyurdum.dto.request;

import com.patika.kitapyurdum.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveRequest {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Integer credit;
    private Long addressId;
}
