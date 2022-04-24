package com.example.library.service;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.Category;
import com.example.library.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> findById(Long id);

    List<Book> findAll();

    Optional<Book> save(BookDto bookDto);

    Optional<Book> save(Long id, String name, Category category, Author author, Integer availableCopies);

    void deleteById(Long id);

    Optional<Book> edit(Long id, String name, Category category, Author author, Integer availableCopies);
    Optional<Book> edit(Long id, BookDto bookDto);

    Optional<Book> decreaseAvailableBooks(Long id);
}
