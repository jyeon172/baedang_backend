package com.example.baedang_backend.domain.alarm.dao;

import com.example.baedang_backend.domain.alarm.model.Alarm;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AlarmRepository extends JpaRepository<Alarm, Long> {

    Optional<Alarm> findById(Long id);

    @Query(value="SELECT a.* FROM alarm a left join member_stock ms on ms.member_stock_id = a.member_stock_id where ms.member_id = :member_id", nativeQuery = true)
    List<Alarm> findAlarmsByMemberId(@Param("member_id") Long member_id);

}
