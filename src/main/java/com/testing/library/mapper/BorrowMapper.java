package com.testing.library.mapper;

import org.springframework.stereotype.Component;

import com.testing.library.model.entities.Borrow;
import com.testing.library.model.io.BorrowResponseDto;

@Component
public class BorrowMapper {
      public BorrowResponseDto toResponse(Borrow borrow) {
            return BorrowResponseDto(
                  borrow.getId(),
                  borrow.getBook().getId(),
                  borrow.getMember().getId(),
                  borrow.getStatus().name(),
                  borrow.getBorrowedAt(),
                  borrow.getReturnedAt()
            );
      }
}
