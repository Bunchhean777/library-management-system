package com.testing.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testing.library.entities.Borrow;
import java.util.List;


@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long>{
      List<Borrow> findByBookId(Long id);
}
