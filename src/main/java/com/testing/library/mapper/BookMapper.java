package com.testing.library.mapper;

import java.util.List;

import com.testing.library.model.entities.Book;
import com.testing.library.model.entities.Borrow;
import com.testing.library.model.io.BookDto;

public class BookMapper {

      public static BookDto toDto(Book book) {
            if (book == null) return null;

            List<Long> borrowIds = book.getBorrows()
                  .stream()
                  .map(Borrow::getId)
                  .toList();

            return BookDto.builder()
                  .id(book.getId())
                  .title(book.getTitle())
                  .author(book.getAuthor())
                  .isbn(book.getIsbn())
                  .category(book.getCategory())
                  .quantity(book.getQuantity())
                  .borrowId(borrowIds)
                  .build();

      }

      public static Book toBook(BookDto dto) {
            if (dto == null) return null;
            return Book.builder()
                  .id(dto.getId())
                  .title(dto.getTitle())
                  .author(dto.getAuthor())
                  .isbn(dto.getIsbn())
                  .category(dto.getCategory())
                  .quantity(dto.getQuantity())
                  .build();
      }
}
