package com.axeld.library.repository;

import com.axeld.library.model.Book;
import com.axeld.library.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByState(State state);

    boolean existsByIsbn(String isbn);
}
