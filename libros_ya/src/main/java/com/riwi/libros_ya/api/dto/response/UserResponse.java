package com.riwi.libros_ya.api.dto.response;

import com.riwi.libros_ya.util.enums.RoleUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String full_name;
    private RoleUser role;
    private List<LoanToUserResp> loans;
    private List<ReservationToUserResp> reservations;
}
