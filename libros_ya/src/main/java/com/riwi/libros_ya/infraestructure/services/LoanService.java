package com.riwi.libros_ya.infraestructure.services;

import com.riwi.libros_ya.api.dto.request.LoanRequest;
import com.riwi.libros_ya.api.dto.response.LoanResponse;
import com.riwi.libros_ya.domain.entities.Loan;
import com.riwi.libros_ya.domain.repositories.LoanRepository;
import com.riwi.libros_ya.domain.repositories.UserRepository;
import com.riwi.libros_ya.infraestructure.abstract_serives.ILoanService;
import com.riwi.libros_ya.infraestructure.helpers.LoanMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoanService implements ILoanService {

    @Autowired
    private final LoanRepository loanRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final LoanMapper loanMapper;

    @Override
    public void delete(Long id) {

    }

    @Override
    public LoanResponse create(LoanRequest loanRequest) {
        Loan loan = this.loanMapper.loanReqToEntity(loanRequest);

        //Se crea activo
        loan.setStatus("Activo");
        loan.setUser(this.userRepository.findById(loanRequest.getUser_id()).orElseThrow());
        loan = this.loanRepository.save(loan);
        return this.loanMapper.entityToLoanResp(loan);
    }

    @Override
    public LoanResponse update(Long id, LoanRequest loanRequest) {
        return null;
    }

    @Override
    public List<LoanResponse> getAll() {
        return null;
    }

    @Override
    public LoanResponse getById(Long aLong) {
        return null;
    }
}
