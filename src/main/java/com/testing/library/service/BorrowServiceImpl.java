package com.testing.library.service;

import org.springframework.stereotype.Service;

import com.testing.library.enums.BorrowStatus;
import com.testing.library.exception.BusinessException;
import com.testing.library.exception.ResourceNotFoundException;
import com.testing.library.mapper.BorrowMapper;
import com.testing.library.model.entities.Book;
import com.testing.library.model.entities.Borrow;
import com.testing.library.model.entities.Member;
import com.testing.library.model.io.BorrowResponseDto;
import com.testing.library.repository.BookRepository;
import com.testing.library.repository.BorrowRepository;
import com.testing.library.repository.MemberRepository;

import jakarta.transaction.Transactional;

@Service
public class BorrowServiceImpl implements BorrowService{

      private final BorrowRepository borrowRepository;
      private final BookRepository bookRepository;
      private final MemberRepository memberRepository;
      private final BorrowMapper borrowMapper;

      public BorrowServiceImpl(
            BorrowRepository borrowRepository,
            BookRepository bookRepository,
            MemberRepository memberRepository,
            BorrowMapper borrowMapper
      ){
            this.borrowRepository = borrowRepository;
            this.bookRepository = bookRepository;
            this.memberRepository = memberRepository;
            this.borrowMapper = borrowMapper;
      }

      @Override
      @Transactional
      public BorrowResponseDto borrow(BorrowResponseDto request) {
            Book book = bookRepository.findById(request.bookId())
                  .orElseThrow(() -> new ResourceNotFoundException("Book not found : " + request.bookId()));
            Member member = memberRepository.findById(request.memberId())
                  .orElseThrow(() -> new ResourceNotFoundException("Member not found : " + request.memberId()));
            
            Borrow borrow = Borrow.create(book, member);
            Borrow saved = borrowRepository.save(borrow);
            return borrowMapper.toResponse(saved);
      }

      @Override
      @Transactional
      public BorrowResponseDto returnBook(Long borrowId) {
            Borrow borrow = borrowRepository.findById(borrowId)
                  .orElseThrow(() -> new ResourceNotFoundException("Book not found : " + borrowId));
            if (borrow.getStatus().equals(BorrowStatus.RETURNED)) {
                  throw new BusinessException("Book already returned");
            }
            borrow.markReturned();
            return borrowMapper.toResponse(borrow);
      }

}