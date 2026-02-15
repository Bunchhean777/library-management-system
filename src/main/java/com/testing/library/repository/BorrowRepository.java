package com.testing.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testing.library.entities.Borrow;
import com.testing.library.status.BorrowStatus;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long>{
    List<Borrow> findbyStatus(BorrowStatus status);
}
