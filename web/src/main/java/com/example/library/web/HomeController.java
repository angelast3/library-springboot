package com.example.library.web;

import com.example.library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private final BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getHomePage(Model model){
        model.addAttribute("books", bookService.findAll());
        return "home";
    }

    @GetMapping("/add")
    public String addCopy(Model model){
        bookService.decreaseAvailableBooks((long) 2);
        model.addAttribute("books", bookService.findAll());
        return "home";
    }
}
