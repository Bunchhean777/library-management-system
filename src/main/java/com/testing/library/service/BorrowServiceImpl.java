package com.testing.library.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.testing.library.dto.BorrowDto;
import com.testing.library.entities.Book;
import com.testing.library.entities.Borrow;
import com.testing.library.entities.Member;
import com.testing.library.exception.BadRequestException;
import com.testing.library.exception.ResourceNotFoundException;
import com.testing.library.mapper.BorrowMapper;
import com.testing.library.repository.BookRepository;
import com.testing.library.repository.BorrowRepository;
import com.testing.library.repository.MemberRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BorrowServiceImpl implements BorrowService{

      private final BorrowRepository borrowRepo;
      private final BookRepository bookRepo;
      private final MemberRepository memberRepo;

      public BorrowServiceImpl(
            final BorrowRepository borrowRepo,
            final BookRepository bookRepo, 
            final MemberRepository memberRepo
      ) {
            this.borrowRepo = borrowRepo;
            this.bookRepo = bookRepo;
            this.memberRepo = memberRepo;
      }

      @Override
      public BorrowDto create(BorrowDto dto) {

            if (dto.getBookId() == null) {
                  throw new BadRequestException("Book id is required.");
            }
            if (dto.getBorrowDate() == null) {
                  dto.setBorrowDate(LocalDateTime.now());
            }

            Book book = bookRepo.findById(dto.getBookId())
                  .orElseThrow(() -> new ResourceNotFoundException("Book not found: " + dto.getBookId()));

            Member member = memberRepo.findById(dto.getMemberId())
                  .orElseThrow(() -> new ResourceNotFoundException("Member not found: " + dto.getMemberId()));

            if (book.getQuantity() != 0 && book.getQuantity() <= 0) {
                  throw new BadRequestException("Book is out of stock");
            }

            Borrow borrow = BorrowMapper.toBorrow(dto, book, member);
            Borrow borrowed = borrowRepo.save(borrow);

            if (book.getQuantity() != 0) {
                  book.setQuantity(book.getQuantity() - 1);
            }

            return BorrowMapper.toDto(borrowed);
      }

      @Override
      public BorrowDto findByid(Long id, BorrowDto dto) {
            Borrow borrow = borrowRepo.findById(id)
                  .orElseThrow(() -> new ResourceNotFoundException("Borrow not found: " + id));
            return BorrowMapper.toDto(borrow);
      }

      @Override
      public List<BorrowDto> findAllBorrows() {
            return borrowRepo.findAll()
                  .stream()
                  .map(BorrowMapper::toDto)
                  .toList();
      }

      @Override
      public void deleteBorrow(Long id) {
            Borrow borrow = borrowRepo.findById(id)
                  .orElseThrow(() -> new ResourceNotFoundException("Borrow not found: " + id));

            if (borrow.getReturnDate() == null) {
                  Book book = borrow.getBook();
                  if (book.getQuantity() != 0) {
                        book.setQuantity(book.getQuantity() + 1);
                  }
            }
            
            borrowRepo.delete(borrow);
      }

      @Override
      public BorrowDto updateBorrow(Long id, LocalDateTime returnDate) {

        Borrow borrow = borrowRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Borrow not found: " + id));

        if (borrow.getReturnDate() != null) {
            throw new BadRequestException("This borrow is already returned");
        }

        Book book = borrow.getBook();

        if (book.getQuantity() != 0) {
            book.setQuantity(book.getQuantity() + 1);
        }

      LocalDateTime returnDateTime = Optional.ofNullable(returnDate).orElse(LocalDateTime.now());
      borrow.setReturnDate(returnDateTime);

        return BorrowMapper.toDto(borrow);
      }

      @Override
      public List<BorrowDto> getByBookId(Long id) {
            return borrowRepo.findByBookId(id)
                  .stream()
                  .map(BorrowMapper::toDto)
                  .toList();
      }

}