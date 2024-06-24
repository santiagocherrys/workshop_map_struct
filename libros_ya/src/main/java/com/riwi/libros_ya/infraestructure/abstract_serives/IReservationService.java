package com.riwi.libros_ya.infraestructure.abstract_serives;

import com.riwi.libros_ya.api.dto.request.ReservationRequest;
import com.riwi.libros_ya.api.dto.response.ReservationResponse;
import com.riwi.libros_ya.domain.entities.User;

import java.util.List;

public interface IReservationService extends CrudService<ReservationRequest, ReservationResponse,Long>{
    List<ReservationResponse> findByUserId(Long user_id);

    List<ReservationResponse> findByBookId(Long book_id);
}
