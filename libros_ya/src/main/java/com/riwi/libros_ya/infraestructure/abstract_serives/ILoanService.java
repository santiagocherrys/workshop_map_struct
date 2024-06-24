package com.riwi.libros_ya.infraestructure.abstract_serives;

import com.riwi.libros_ya.api.dto.request.LoanRequest;
import com.riwi.libros_ya.api.dto.response.LoanResponse;
import com.riwi.libros_ya.domain.entities.Loan;

import java.util.List;

public interface ILoanService extends CrudService<LoanRequest, LoanResponse,Long>{
    List<LoanResponse> findByUserId(Long user_id);
}
