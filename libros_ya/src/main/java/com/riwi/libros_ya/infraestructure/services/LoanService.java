package com.riwi.libros_ya.infraestructure.services;

import com.riwi.libros_ya.api.dto.request.LoanRequest;
import com.riwi.libros_ya.api.dto.response.LoanResponse;
import com.riwi.libros_ya.domain.entities.Book;
import com.riwi.libros_ya.domain.entities.Loan;
import com.riwi.libros_ya.domain.repositories.BookRepository;
import com.riwi.libros_ya.domain.repositories.LoanRepository;
import com.riwi.libros_ya.domain.repositories.UserRepository;
import com.riwi.libros_ya.infraestructure.abstract_serives.ILoanService;
import com.riwi.libros_ya.infraestructure.helpers.LoanMapper;
import com.riwi.libros_ya.util.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class LoanService implements ILoanService {

    @Autowired
    private final LoanRepository loanRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private final LoanMapper loanMapper;

    @Override
    public void delete(Long id) {
        this.loanRepository.delete(this.find(id));
    }

    @Override
    public LoanResponse create(LoanRequest loanRequest) {
        Loan loan = this.loanMapper.loanReqToEntity(loanRequest);

        //Se crea activo
        loan.setStatus("Activo");
        //Se rectifica si hay user
        loan.setUser(this.userRepository.findById(loanRequest.getUser_id()).orElseThrow(()-> new IdNotFoundException("User")));
        //Se rectifica si hay libro
        loan.setBook(this.bookRepository.findById(loanRequest.getBook_id()).orElseThrow(()-> new IdNotFoundException("Book")));
        loan = this.loanRepository.save(loan);
        return this.loanMapper.entityToLoanResp(loan);
    }

    @Override
    public LoanResponse update(Long id, LoanRequest loanRequest) {
        //Se crea objeto
        Loan loan = new Loan();
        loan = this.find(id);
        loan.setReturn_date(loanRequest.getReturn_date());
        //Se pone la hora
        LocalDateTime today = LocalDateTime.now();
        loan.setLoan_date(today);
        loan.setStatus(loanRequest.getStatus());

        return this.loanMapper.entityToLoanResp(loan);
    }

    @Override
    public List<LoanResponse> getAll() {
        return this.loanMapper.toListLoanResp(this.loanRepository.findAll());
    }

    @Override
    public LoanResponse getById(Long id){

        return this.loanMapper.entityToLoanResp(this.find(id));
    }

    private Loan find(long id){
        return this.loanRepository.findById(id).orElseThrow(()-> new IdNotFoundException("Loan"));
    }
}
