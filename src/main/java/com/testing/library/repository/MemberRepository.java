package com.testing.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testing.library.entities.Member;
import com.testing.library.status.MemberStatus;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
    List<Member> findByStatus(MemberStatus status);
}
