package com.patika.kitapyurdum.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessages {

    // NOT_FOUND
    public static final String CUSTOMER_NOT_FOUND = "Customer not found!";
    public static final String AUTHOR_NOT_FOUND = "Author not found!";
    public static final String PUBLISHER_NOT_FOUND = "Publisher not found!";
    public static final String CATEGORY_NOT_FOUND = "Category not found!";
    public static final String PRODUCT_NOT_FOUND = "Product not found!";
    public static final String ADDRESS_NOT_FOUND = "Address not found!";
    public static final String ORDER_NOT_FOUND = "Order not found!";
    public static final String CART_NOT_FOUND = "Cart not found!";
    public static final String BOOK_NOT_FOUND = "Book not found!";
    // ended NOT_FOUND

    //ALREADY_EXIST
    public static final String EMAIL_ALREADY_EXIST = "E-mail already exist!";
    public static final String CUSTOMER_ALREADY_EXIST = "Customer already exist!";
    public static final String PUBLISHER_ALREADY_EXIST = "Publisher already exist!";
    public static final String CATEGORY_ALREADY_EXIST = "Category already exist!";
    public static final String AUTHOR_ALREADY_EXIST = "Author already exist!";
    public static final String ADDRESS_ALREADY_EXIST = "Address already exist!";
    public static final String CART_ALREADY_EXIST = "Cart already exist!";
    public static final String ORDER_ALREADY_EXIST = "Order already exist!";
    public static final String PRODUCT_ALREADY_EXIST = "Product already exist!";
    public static final String BOOK_ALREADY_EXIST = "Book already exist!";
    //ended ALREADY_EXIST

    public static final String CUSTOMER_NOT_ACTIVE = "Customer is not active!";



}
