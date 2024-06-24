package com.riwi.libros_ya.domain.repositories;

import com.riwi.libros_ya.domain.entities.Loan;
import com.riwi.libros_ya.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {
    List<Loan> findByUser(User user);
}
