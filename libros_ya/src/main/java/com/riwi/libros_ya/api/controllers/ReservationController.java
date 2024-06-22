package com.riwi.libros_ya.api.controllers;

import com.riwi.libros_ya.api.dto.request.ReservationPostReq;
import com.riwi.libros_ya.api.dto.request.ReservationRequest;
import com.riwi.libros_ya.api.dto.request.ReservationUpdateRequest;
import com.riwi.libros_ya.api.dto.response.ReservationResponse;
import com.riwi.libros_ya.infraestructure.abstract_serives.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/reservations")
@AllArgsConstructor
public class ReservationController {
    @Autowired
    private final IReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationResponse> insert(
            @RequestBody ReservationPostReq request
            ){
        ReservationRequest reservationRequest = ReservationRequest.builder()
                .user_id(request.getUser_id())
                .book_id(request.getBook_id())
                .reservation_date(request.getReservation_date())
                .build();
        return ResponseEntity.ok(this.reservationService.create(reservationRequest));
    }

    @GetMapping
    public ResponseEntity<List<ReservationResponse>> getAll(){
        return ResponseEntity.ok(this.reservationService.getAll());
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<ReservationResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(this.reservationService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.reservationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ReservationResponse> update(@PathVariable Long id,
                                                      @RequestBody ReservationUpdateRequest request){
        ReservationRequest reservationRequest = ReservationRequest.builder()
                .status(request.getStatus())
                .reservation_date(request.getReservation_date())
                .build();
        return ResponseEntity.ok(this.reservationService.update(id,reservationRequest));
    }

}
