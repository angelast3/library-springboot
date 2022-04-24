package com.example.library.service.impl;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.Category;
import com.example.library.model.dto.BookDto;
import com.example.library.model.exceptions.AuthorNotFoundException;
import com.example.library.model.exceptions.BookNotFoundException;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(AuthorNotFoundException::new);
        Book book1 = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());
        bookRepository.save(book1);
        return Optional.of(book1);
    }

    @Override
    public Optional<Book> save(Long id, String name, Category category, Author author, Integer availableCopies) {
        Author auth = this.authorRepository.findById(author.getId()).orElseThrow(AuthorNotFoundException::new);
        Book book1 = new Book(name, category, auth, availableCopies);
        bookRepository.save(book1);
        return Optional.of(book1);    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Author author, Integer availableCopies) {
        Book book = this.bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        Author auth = this.authorRepository.findById(author.getId()).orElseThrow(AuthorNotFoundException::new);

        book.setAuthor(auth);
        book.setName(name);
        book.setCategory(category);
        book.setAvailableCopies(availableCopies);

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        Author auth = this.authorRepository.findById(bookDto.getAuthor()).orElseThrow(AuthorNotFoundException::new);

        book.setAuthor(auth);
        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> increaseAvailableBooks(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        Author auth = this.authorRepository.findById(book.getAuthor().getId()).orElseThrow(AuthorNotFoundException::new);

        book.setAuthor(auth);
        book.setName(book.getName());
        book.setCategory(book.getCategory());
        book.setAvailableCopies(book.getAvailableCopies()+1);

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> decreaseAvailableBooks(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        Author auth = this.authorRepository.findById(book.getAuthor().getId()).orElseThrow(AuthorNotFoundException::new);

        book.setAuthor(auth);
        book.setName(book.getName());
        book.setCategory(book.getCategory());
        book.setAvailableCopies(book.getAvailableCopies()-1);

        this.bookRepository.save(book);
        return Optional.of(book);
    }
}
