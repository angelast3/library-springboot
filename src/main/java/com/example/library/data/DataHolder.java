package com.example.library.data;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.Category;
import com.example.library.model.Country;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.repository.CountryRepository;
import lombok.Getter;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
public class DataHolder {
    private final BookRepository bookRepository;
    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;
    public DataHolder(BookRepository bookRepository, CountryRepository countryRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
    }


    @PostConstruct
    void init()  {
        Country temp = new Country("Austria", "Europe");
        Country austria = this.countryRepository.save(temp);
        temp =new Country("Germany", "Europe");
        Country germany = this.countryRepository.save(new Country("Germany", "Europe"));
        Country france = this.countryRepository.save(new Country("France", "Europe"));


        Author author1 = this.authorRepository.save(new Author("Arthur", "Beck", austria));
        Author author2 = this.authorRepository.save(new Author("Fiona", "Chan", france));

        Book book = this.bookRepository.save(new Book("The Great Gatsby", Category.NOVEL, author1, 2));
        Book the_hunger_games = this.bookRepository.save(new Book("The hunger games", Category.FANTASY, author1, 10));
        Book little_women = this.bookRepository.save(new Book("Little women", Category.DRAMA, author2, 5));
        Book pinocchio = this.bookRepository.save(new Book("Pinocchio", Category.NOVEL, author1, 6));

    }
}
