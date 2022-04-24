package com.example.library.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Librarian {
    @Id
    private Long id;

    public Librarian() {
    }
}
