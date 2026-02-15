package com.testing.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.testing.library.dto.BookDto;
import com.testing.library.repository.BookRepository;
import com.testing.library.service.BookService;

public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository repo;

    public BookServiceImpl(BookRepository repo) {
        this.repo = repo;
    }

    @Override
    public BookDto create(BookDto book) {
        
        return null;
    }

    @Override
    public BookDto update(Long id, BookDto book) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public BookDto getBookDtoById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookDtoById'");
    }

    @Override
    public List<BookDto> getAllBooks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllBooks'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
