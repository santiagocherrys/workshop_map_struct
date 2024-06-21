package com.riwi.libros_ya.domain.repositories;

import com.riwi.libros_ya.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
