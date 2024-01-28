package com.example.baedang_backend.domain.alarm.model;

import com.example.baedang_backend.domain.member.model.MemberStock;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Alarm {
    @Id
    @Column(name="alarm_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_stock_id")
    private MemberStock memberStock;

    private String message;

    @Enumerated(EnumType.STRING)
    private AlarmDomain alarm_domain;
}
