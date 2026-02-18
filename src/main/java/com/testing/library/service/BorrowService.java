package com.testing.library.service;

import java.time.LocalDateTime;
import java.util.List;

import com.testing.library.borrow.BorrowDto;

public interface BorrowService {
      BorrowDto create(BorrowDto dto);
      BorrowDto findByid(Long id, BorrowDto dto);
      List<BorrowDto> findAllBorrows();
      List<BorrowDto> getByBookId(Long id);
      BorrowDto updateBorrow(Long id, LocalDateTime returnDate);
      void deleteBorrow(Long id);
}
