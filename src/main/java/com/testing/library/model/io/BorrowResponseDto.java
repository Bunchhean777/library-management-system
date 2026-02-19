package com.testing.library.model.io;

import java.time.LocalDate;

public record BorrowResponseDto(
      Long id,
      Long bookId,
      Long memberId,
      String status,
      LocalDate borrowDate,
      LocalDate returnDate
) {}
