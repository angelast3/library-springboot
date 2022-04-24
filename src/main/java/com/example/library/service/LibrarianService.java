package com.example.library.service;

import com.example.library.model.Librarian;

import java.util.List;
import java.util.Optional;

public interface LibrarianService {
    Optional<Librarian> findById(Long id);

    List<Librarian> findAll();

}
