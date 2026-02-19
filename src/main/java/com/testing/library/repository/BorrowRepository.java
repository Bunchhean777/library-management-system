package com.testing.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testing.library.model.entities.Borrow;


@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long>{
}
