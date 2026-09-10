package com.axeld.library.controller;

import com.axeld.library.dto.BookCreateRequest;
import com.axeld.library.model.Book;
import com.axeld.library.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/available")
    public List<Book> getAvailableBooks() {
        return bookService.getAvailableBooks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@Valid @RequestBody BookCreateRequest bookCreateRequest) {
        Book book = Book.builder()
                .title(bookCreateRequest.title())
                .author(bookCreateRequest.author())
                .isbn(bookCreateRequest.isbn())
                .build();
        return bookService.addBook(book);
    }


}
