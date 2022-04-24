package com.example.library.web.rest;

import com.example.library.model.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryRestController {


    @GetMapping
    private Category[] findAll() {
//        return this.bookService.findAll();
        return Category.values();
    }
}
