package com.riwi.libros_ya.infraestructure.helpers;

import com.riwi.libros_ya.api.dto.request.LoanRequest;
import com.riwi.libros_ya.api.dto.response.LoanResponse;
import com.riwi.libros_ya.domain.entities.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanMapper {

    Loan loanReqToEntity(LoanRequest loanReq);

    LoanResponse entityToLoanResp(Loan loan);
}
