package com.testing.library.entities;

import java.time.LocalDateTime;

import com.testing.library.status.BorrowStatus;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_borrow")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id")
    private Long id;

    // Many-To-One
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;


    // Many-To-One
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "borrow_id", nullable = false)
    private Book book;

    private LocalDateTime borrow_date;
    private LocalDateTime due_date;
    private LocalDateTime return_date;
    private LocalDateTime create_at;

    @Enumerated(EnumType.STRING)
    private BorrowStatus borrow;
}
