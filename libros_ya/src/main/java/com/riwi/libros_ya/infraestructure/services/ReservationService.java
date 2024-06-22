package com.riwi.libros_ya.infraestructure.services;

import com.riwi.libros_ya.api.dto.request.ReservationRequest;
import com.riwi.libros_ya.api.dto.response.ReservationResponse;
import com.riwi.libros_ya.domain.entities.Reservation;
import com.riwi.libros_ya.domain.repositories.BookRepository;
import com.riwi.libros_ya.domain.repositories.ReservationRepository;
import com.riwi.libros_ya.domain.repositories.UserRepository;
import com.riwi.libros_ya.infraestructure.abstract_serives.IReservationService;
import com.riwi.libros_ya.infraestructure.helpers.ReservationMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {

    @Autowired
    private final ReservationRepository reservationRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private final ReservationMapper reservationMapper;
    @Override
    public void delete(Long id) {
        this.reservationRepository.delete(this.find(id));
    }

    @Override
    public ReservationResponse create(ReservationRequest reservationRequest) {
        Reservation reservation = this.reservationMapper.reservationReqToEntity(reservationRequest);

        //Se crea activo
        reservation.setStatus("Activo");
        //Se rectifica si hay user
        reservation.setUser(this.userRepository.findById(reservationRequest.getUser_id()).orElseThrow());
        //Se rectifica si hay book
        reservation.setBook(this.bookRepository.findById(reservationRequest.getBook_id()).orElseThrow());
        //Se guarda en la base de datos
        reservation = this.reservationRepository.save(reservation);
        return this.reservationMapper.entityToReservationResp(reservation);
    }

    @Override
    public ReservationResponse update(Long id, ReservationRequest reservationRequest) {
        //Se crea objeto
        Reservation reservation = new Reservation();
        reservation = this.find(id);
        reservation.setReservation_date(reservationRequest.getReservation_date());
        reservation.setStatus(reservationRequest.getStatus());

        return this.reservationMapper.entityToReservationResp(reservation);
    }

    @Override
    public List<ReservationResponse> getAll() {
        return this.reservationMapper.toListReservationResp(this.reservationRepository.findAll());
    }

    @Override
    public ReservationResponse getById(Long id) {
        return this.reservationMapper.entityToReservationResp(this.find(id));
    }

    private Reservation find(Long id){
        return this.reservationRepository.findById(id).orElseThrow();
    }
}
