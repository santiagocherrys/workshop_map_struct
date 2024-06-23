package com.riwi.libros_ya.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationPostReq {

    private Long user_id;
    private Long book_id;
    @NotBlank(message= "El campo reservation_date es requerido")
    private LocalDateTime reservation_date;
}
