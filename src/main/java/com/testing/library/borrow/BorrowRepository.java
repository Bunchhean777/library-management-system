package com.testing.library.borrow;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long>{
      List<Borrow> findByBookId(Long id);
}
