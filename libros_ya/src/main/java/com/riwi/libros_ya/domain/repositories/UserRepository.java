package com.riwi.libros_ya.domain.repositories;

import com.riwi.libros_ya.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
