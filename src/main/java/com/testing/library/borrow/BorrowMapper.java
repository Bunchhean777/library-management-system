package com.testing.library.borrow;

import com.testing.library.book.Book;
import com.testing.library.member.Member;


public class BorrowMapper {

      public static BorrowDto toDto(Borrow borrow) {
            if (borrow == null) return null;
            return BorrowDto.builder()
                  .id(borrow.getId())
                  .borrowDate(borrow.getBorrowDate())
                  .returnDate(borrow.getReturnDate())
                  .bookId(borrow.getBook().getId())
                  .memberId(borrow.getMember().getId())
                  .build();
      }

      public static Borrow toBorrow(
            BorrowDto dto,
            Book book, 
            Member member
      ) {
            if (dto == null) return null;
            return Borrow.builder()
                  .id(dto.getId())
                  .borrowDate(dto.getBorrowDate())
                  .returnDate(dto.getReturnDate())
                  .member(member)
                  .book(book)
                  .build();
      }
}
