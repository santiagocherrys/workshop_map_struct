package com.riwi.libros_ya.api.dto.response;

import com.riwi.libros_ya.domain.entities.Book;
import com.riwi.libros_ya.domain.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse {
    private Long id;
    private LocalDateTime reservation_date;
    private String status;

    private UserBasicResp user;
    private BookToReservationResp book;
}
