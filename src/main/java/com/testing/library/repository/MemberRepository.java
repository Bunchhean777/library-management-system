package com.testing.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testing.library.entities.Member;

@Repository
public interface MemberRepository extends  JpaRepository<Member, Long>{
}
