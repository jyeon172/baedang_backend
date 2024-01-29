package com.example.baedang_backend.domain.member.dao;

import com.example.baedang_backend.domain.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(Long aLong);
}
