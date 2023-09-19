package com.cydeo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.List;

public class Ticket {
    private Long id;
    private int seatNumber;
    private int rowNumber;
    @Column(columnDefinition = "Date")
    private LocalDate dateTime;
    @ManyToOne
    private MovieCinema movieCinema;

    @ManyToOne
    private UserAccount userAccount;


}
