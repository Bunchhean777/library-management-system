package com.testing.library.service;

import com.testing.library.dto.BorrowDto;

public class BorrowServiceImpl implements BorrowService{

      @Override
      public BorrowDto create(BorrowDto dto) {
            return null;
      }

}

      //   Book book = bookRepository.findById(dto.getBookId())
      //           .orElseThrow(() -> new RuntimeException("Book not found"));

      //   Borrow borrow = BorrowMapper.toEntity(dto, book);

      //   Borrow saved = borrowRepository.save(borrow);

      //   return BorrowMapper.toDTO(saved);
