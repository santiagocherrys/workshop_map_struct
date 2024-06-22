package com.riwi.libros_ya.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookToReservationResp {
    private Long id;
    private String title;
    private String author;
    private int publication_year;
    private String genre;
    private String isbn;

    List<LoanToBookResp> loans;
}
