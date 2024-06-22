package com.riwi.libros_ya.api.dto.response;

import java.util.List;

import com.riwi.libros_ya.domain.entities.Loan;
import com.riwi.libros_ya.domain.entities.Reservation;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    private Long id;
    private String title;
    private String author;
    private int publication_year;
    private String genre;
    private String isbn;

    List<ReservationToBookResp> reservations;
    List<LoanToBookResp> loans;


}
