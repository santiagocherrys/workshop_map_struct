package com.riwi.libros_ya.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanRequest {
    private Long user_id;
    private Long book_id;
    private LocalDateTime return_date;
}
