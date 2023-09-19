package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@NoArgsConstructor
@Data

public class Genre extends BaseEntity {

    private String name;

    @ManyToMany
    @JoinTable(name ="movieGenreRel" ,
              joinColumns = @JoinColumn(name = "genre_id"),
              inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movieList;
}
