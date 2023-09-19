package com.cydeo.entity;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class MovieCinema {

    private LocalDate date_time;

    @ManyToOne
    private Cinema cinema;
    @OneToMany(mappedBy = "movieCinema")
    private List<Ticket> ticketList;



}
