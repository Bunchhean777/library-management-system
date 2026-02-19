package com.testing.library.model.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "tbl_book")
public class Book {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String title;

    
    private String author;
    private String category;
    
    @Column(nullable=false)
    private int availableCopies;
    
    @OneToMany(mappedBy= "book", cascade= CascadeType.ALL)
    private List<Borrow> borrows = new ArrayList<>();

    public Book() {}
    
    public void decreaseAvailableCopies(int amount) {
    if (availableCopies - amount < 0) throw new
    IllegalStateException("availableCopies < 0");
    this.availableCopies -= amount;
    }
    public void increaseAvailableCopies(int amount) {
    this.availableCopies += amount;
    }

}
