package com.riwi.libros_ya.infraestructure.helpers;

import com.riwi.libros_ya.api.dto.request.ReservationRequest;
import com.riwi.libros_ya.api.dto.response.ReservationResponse;
import com.riwi.libros_ya.domain.entities.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper{
    Reservation reservationReqToEntity(ReservationRequest reservationReq);

    ReservationResponse entityToReservationResp(Reservation reservation);

    List<ReservationResponse> toListReservationResp(List<Reservation> reservations);

}
