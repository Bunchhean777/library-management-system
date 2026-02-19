package com.testing.library.model.entities;

import java.time.LocalDate;

import com.testing.library.enums.BorrowStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "borrows")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    @JoinColumn(name="book_id" , nullable=false)
    private Book book;

    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    @JoinColumn(name="member_id", nullable=false)
    private Member member;

    @Enumerated(EnumType.STRING)
    private BorrowStatus status;

    @Column(nullable=false)
    private LocalDate borrowedAt;
    
    private LocalDate returnedAt;

    protected Borrow() {}

    public static Borrow create(Book book, Member member) {
        Borrow b = new Borrow();
        b.book = book;
        b.member = member;
        b.status = BorrowStatus.BORROWED;
        b.borrowedAt = LocalDate.now();
        return b;
    }

    public void markReturned() {
        this.status = BorrowStatus.RETURNED;
        this.returnedAt = LocalDate.now();
    }

    public BorrowStatus getStatus() {
        return status;
    }

    public Book getBook() {
        return book;
    }

    public Long getId() {
        return id;
    }
}