package com.cydeo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity  // 1-tablo otamatik oluşturdu
public class Employee {

    @Id   // 2- Primary key tanıttık
    private int id;
    private String name;

}
