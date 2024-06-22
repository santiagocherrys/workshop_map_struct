package com.riwi.libros_ya.api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationToUserResp {
    private Long id;
    private LocalDateTime reservation_date;
    private String status;

    //private Book book;
}
