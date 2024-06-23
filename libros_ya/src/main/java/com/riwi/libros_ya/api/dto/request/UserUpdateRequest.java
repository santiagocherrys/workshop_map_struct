package com.riwi.libros_ya.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateRequest {
    @NotBlank(message= "El campo username es requerido")
    @Size(min = 0 , max = 50, message = "El nombre de username supera la cantidad de caracteres permitidos")
    private String username;
    @NotBlank(message= "El campo password es requerido")
    @Size(min = 0 , max = 100, message = "El valor de password supera la cantidad de caracteres permitidos")
    private String password;
    @NotBlank(message= "El campo email es requerido")
    @Size(min = 0 , max = 100, message = "El nombre de email supera la cantidad de caracteres permitidos")
    @Email(message = "ingrese un email valido")
    private String email;
    @NotBlank(message= "El campo fullname es requerido")
    @Size(min = 0 , max = 100, message = "El nombre de full_name supera la cantidad de caracteres permitidos")
    private String full_name;
}
