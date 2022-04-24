package com.example.library.service.impl;

import com.example.library.model.Librarian;
import com.example.library.repository.LibrarianRepository;
import com.example.library.service.LibrarianService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibrarianServiceImpl implements LibrarianService {

    private final LibrarianRepository librarianRepository;

    public LibrarianServiceImpl(LibrarianRepository librarianRepository) {
        this.librarianRepository = librarianRepository;
    }

    @Override
    public Optional<Librarian> findById(Long id) {
        return this.librarianRepository.findById(id);
    }

    @Override
    public List<Librarian> findAll() {
        return this.librarianRepository.findAll();
    }
}
