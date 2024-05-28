package com.patika.kitapyurdum.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Address {

    private String title;
    private String province;
    private String description;

}
