package com.blinets.firstStep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.blinets.firstStep.domain.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
