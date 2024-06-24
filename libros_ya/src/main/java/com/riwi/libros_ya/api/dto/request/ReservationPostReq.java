package com.riwi.libros_ya.api.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message= "El campo reservation_date es requerido")
    //@JsonFormat(pattern = "YYYY-MM-DD HH:MM:SS")
    private LocalDateTime reservation_date;
}
