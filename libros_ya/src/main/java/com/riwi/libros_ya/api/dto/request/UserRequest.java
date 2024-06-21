package com.riwi.libros_ya.api.dto.request;

import com.riwi.libros_ya.util.enums.RoleUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String username;
    private String password;
    private String email;
    private String full_name;
    private RoleUser role;
}
