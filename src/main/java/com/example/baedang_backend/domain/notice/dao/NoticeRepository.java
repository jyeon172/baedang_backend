package com.example.baedang_backend.domain.notice.dao;

import com.example.baedang_backend.domain.notice.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    Optional<Notice> findById(Long id);

    @Query(value = "SELECT n.* FROM notice n " +
            "left join member_stock ms " +
            "on ms.member_stock_id = n.member_stock_id " +
            "where ms.member_id = :user_id and ms.stock_id = :stock_id", nativeQuery = true)
    List<Notice> findMemberNoticesByStockId(@Param("user_id") Long user_id, @Param("stock_id") Long stock_id);
}
