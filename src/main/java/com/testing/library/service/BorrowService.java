package com.testing.library.service;

import com.testing.library.model.io.BorrowResponseDto;

public interface BorrowService {
      BorrowResponseDto borrow(BorrowResponseDto request);
      BorrowResponseDto returnBook(Long borrowId);
}
