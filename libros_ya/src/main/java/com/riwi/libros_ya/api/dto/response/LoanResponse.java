package com.riwi.libros_ya.api.dto.response;

import com.riwi.libros_ya.domain.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanResponse {
    private Long id;
    private LocalDateTime loan_date;
    private LocalDateTime return_date;
    private String status;
    private UserBasicResp user;
    private BookToLoanResp book;
}
