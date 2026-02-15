package com.testing.library.service;

import java.util.List;

import com.testing.library.dto.BookDto;



public interface BookService {

    BookDto create(BookDto book);
    BookDto update(Long id, BookDto book);
    BookDto getBookDtoById(Long id);
    List<BookDto> getAllBooks();
    void delete(Long id);

}
