package com.testing.library.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private int isbn;
    private String category;
}
