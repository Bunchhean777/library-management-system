package com.testing.library.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private int isbn;
    private String category;
    private int quantity;

    private List<Long> borrowId;
}
