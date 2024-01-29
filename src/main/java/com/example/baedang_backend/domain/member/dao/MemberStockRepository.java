package com.example.baedang_backend.domain.member.dao;

import com.example.baedang_backend.domain.member.model.MemberStock;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberStockRepository extends JpaRepository<MemberStock, Long> {

    @EntityGraph(attributePaths = {"stock"})
    List<MemberStock> findStocksByMemberId(Long member_id);
}
