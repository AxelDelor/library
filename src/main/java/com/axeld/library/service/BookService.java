package com.axeld.library.service;

import com.axeld.library.exception.BookNotFoundException;
import com.axeld.library.exception.IsbnAlreadyExistsException;
import com.axeld.library.model.Book;
import com.axeld.library.model.State;
import com.axeld.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(() ->new BookNotFoundException("Le livre que vous cherchez est introuvable"));
    }

    public List<Book> getAvailableBooks() {
        return bookRepository.findByState(State.AVAILABLE);
    }

    public Book addBook(Book book) {
        if (bookRepository.existsByIsbn(book.getIsbn())) {
            throw new IsbnAlreadyExistsException("Cet Isbn existe déjà");
        }
        book.setState(State.NEW);
        return bookRepository.save(book);
    }


}
