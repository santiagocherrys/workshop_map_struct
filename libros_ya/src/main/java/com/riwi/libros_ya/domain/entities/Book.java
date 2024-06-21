package com.riwi.libros_ya.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String title;
    @Column(length = 100, nullable = false)
    private String author;
    @Column(nullable = false)
    private int publication_year;
    @Column(length = 50, nullable = false)
    private String genre;
    @Column(length = 20, nullable = false)
    private String isbn;

    //Relaciones
    @OneToMany(mappedBy = "book",
                cascade = CascadeType.ALL,
                orphanRemoval = false,
                fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<Reservation> reservations;

    @OneToMany(mappedBy = "book",
                cascade = CascadeType.ALL,
                orphanRemoval = false,
                fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<Loan> loans;

}
