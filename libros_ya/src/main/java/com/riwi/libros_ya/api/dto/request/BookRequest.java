package com.riwi.libros_ya.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequest {
    @NotBlank(message= "El campo title es requerido")
    @Size(min = 0 , max = 100, message = "El nombre de title supera la cantidad de caracteres permitidos")
    private String title;
    @NotBlank(message= "El campo author es requerido")
    @Size(min = 0 , max = 100, message = "El nombre de author supera la cantidad de caracteres permitidos")
    private String author;
    @NotNull(message= "El campo publication_year es requerido")
    private int publication_year;
    @NotBlank(message= "El campo genre es requerido")
    @Size(min = 0 , max = 50, message = "El nombre de genre supera la cantidad de caracteres permitidos")
    private String genre;
    @NotBlank(message= "El campo isbn es requerido")
    @Size(min = 0 , max = 20, message = "El nombre de isbn supera la cantidad de caracteres permitidos")
    private String isbn;
}
