package com.riwi.libros_ya.api.controllers;

import com.riwi.libros_ya.api.dto.request.LoanRequest;
import com.riwi.libros_ya.api.dto.response.LoanResponse;
import com.riwi.libros_ya.infraestructure.abstract_serives.ILoanService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
