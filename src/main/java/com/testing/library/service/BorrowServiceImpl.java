package com.testing.library.service;

import org.springframework.stereotype.Service;

import com.testing.library.dto.BorrowDto;
import com.testing.library.entities.Book;
import com.testing.library.entities.Borrow;
import com.testing.library.entities.Member;
import com.testing.library.mapper.BorrowMapper;
import com.testing.library.repository.BookRepository;
import com.testing.library.repository.MemberRepository;

@Service
public class BorrowServiceImpl implements BorrowService{

      private final BookRepository bookRepo;
      private final MemberRepository memberRepo;

      public BorrowServiceImpl(final BookRepository bookRepo, final MemberRepository memberRepo) {
            this.bookRepo = bookRepo;
            this.memberRepo = memberRepo;
      }

      @Override
      public BorrowDto create(BorrowDto dto) {
            Book book = bookRepo
                  .findById(dto.getBookId())
                  .orElseThrow(() -> new RuntimeException("Book not found"));
            Member member = memberRepo
                  .findById(dto.getMemberId())
                  .orElseThrow(() -> new RuntimeException("Member not found"));
            Borrow borrowed = BorrowMapper.toBorrow(dto, book, member);
            return BorrowMapper.toDto(borrowed);
      }

}

