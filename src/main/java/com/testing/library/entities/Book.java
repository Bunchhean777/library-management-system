package com.testing.library.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_book")
public class Book {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book_name")
    private String title;

    @Column(name = "book_author")
    private String author;

    @Column(name = "book_isbn")
    private int isbn;

    @Column(name = "category")
    private String category;

    @Column(name = "book_qty")
    private int quantity;

    @Column(name = "book_availabel")
    private int available_qauntity;
    
    private LocalDateTime create_at;
    
    @OneToMany(mappedBy = "member")
    private List<Borrow> borrow;
}
