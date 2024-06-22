package com.riwi.libros_ya.infraestructure.abstract_serives;

import com.riwi.libros_ya.api.dto.request.LoanRequest;
import com.riwi.libros_ya.api.dto.response.LoanResponse;

public interface ILoanService extends CrudService<LoanRequest, LoanResponse,Long>{
}
