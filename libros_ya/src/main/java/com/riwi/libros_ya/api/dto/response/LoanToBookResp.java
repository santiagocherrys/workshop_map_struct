package com.riwi.libros_ya.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanToBookResp {
    private Long id;
    private LocalDateTime loan_date;
    private LocalDateTime return_date;
    private String status;

    private UserBasicResp user;
}
