package com.riwi.libros_ya.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanUpdateRequest {
    @NotBlank(message= "El campo status es requerido")
    @Size(min = 0 , max = 20, message = "El nombre de status supera la cantidad de caracteres permitidos")
    private String status;
    private LocalDateTime return_date;
}
