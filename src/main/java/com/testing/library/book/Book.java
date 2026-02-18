package com.testing.library.book;

import java.util.ArrayList;
import java.util.List;

import com.testing.library.borrow.Borrow;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_book")
@Builder
public class Book {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private int isbn;
    private String category;
    private int quantity;

    @OneToMany(mappedBy= "book", cascade= CascadeType.ALL)
    private final List<Borrow> borrows = new ArrayList<>();

}
