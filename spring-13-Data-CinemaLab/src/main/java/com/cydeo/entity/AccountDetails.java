package com.cydeo.entity;

import jakarta.persistence.OneToOne;

public class AccountDetails {

    private Long id;
    private String name;
    private String address;
    private String country;
    private String city;
    private String state;
    private String postalCode;
    @OneToOne
    private UserAccount userAccount;
}
