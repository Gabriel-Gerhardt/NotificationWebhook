package com.project.library.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private Integer bornYear;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author(String name, Integer bornYear, List<Book> books) {
        this.name = name;
        this.bornYear = bornYear;
        this.books = books;
    }
}
