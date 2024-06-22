package com.riwi.libros_ya.api.controllers;

import com.riwi.libros_ya.api.dto.request.BookRequest;
import com.riwi.libros_ya.api.dto.request.LoanRequest;
import com.riwi.libros_ya.api.dto.request.LoanUpdateRequest;
import com.riwi.libros_ya.api.dto.response.LoanResponse;
import com.riwi.libros_ya.domain.entities.Loan;
import com.riwi.libros_ya.infraestructure.abstract_serives.ILoanService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "loans")
@AllArgsConstructor
public class LoanController {
    @Autowired
    private final ILoanService loanService;

    @PostMapping
    public ResponseEntity<LoanResponse> insert(
            @RequestBody LoanRequest request
            ){
        return ResponseEntity.ok(this.loanService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<LoanResponse>> getAll(){
        return ResponseEntity.ok(this.loanService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<LoanResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(this.loanService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.loanService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<LoanResponse> update(@PathVariable Long id,
                                               @RequestBody LoanUpdateRequest request){
        LoanRequest loanRequest = new LoanRequest();
        loanRequest.setStatus(request.getStatus());
        loanRequest.setReturn_date(request.getReturn_date());
        return ResponseEntity.ok(this.loanService.update(id,loanRequest));
    }
}
