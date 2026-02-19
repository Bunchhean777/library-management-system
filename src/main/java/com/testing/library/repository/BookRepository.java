package com.testing.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testing.library.model.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
}