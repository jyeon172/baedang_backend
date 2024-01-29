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

    @Query(value = "SELECT * FROM member_stock ms WHERE ms.member_id = :member_id and ms.stock_id = :stock_id", nativeQuery = true)
    List<MemberStock> findByMemberAndStock(@Param("member_id") Long member_id, @Param("stock_id") Long stock_id);
}
