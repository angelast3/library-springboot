package com.example.library.web.rest;

import com.example.library.model.Author;
import com.example.library.model.Librarian;
import com.example.library.service.LibrarianService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://library-react-193199.herokuapp.com")
@RequestMapping("/api/librarians")
public class LibrarianRestController {

    private final LibrarianService librarianService;

    public LibrarianRestController(LibrarianService librarianService) {
        this.librarianService = librarianService;
    }
    @GetMapping
    private List<Librarian> findAll(){
        return this.librarianService.findAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Librarian> findById(@PathVariable Long id){
        return this.librarianService.findById(id).map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
