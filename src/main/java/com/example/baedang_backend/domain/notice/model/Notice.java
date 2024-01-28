package com.example.baedang_backend.domain.notice.model;


import com.example.baedang_backend.domain.member.model.MemberStock;
import com.example.baedang_backend.domain.stock.model.StockType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Notice {
    @Id
    @Column(name="notice_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_stock_id")
    private MemberStock memberStock;

    private LocalDateTime payment_period;

    private LocalDateTime base_date;

    private Long member_num;

    @Enumerated(EnumType.STRING)
    private StockType stock_type;

    private Double cash_rate;

    private Double stock_rate;

    private Double short_holding;

    private Double cash_price;

    private Double stock_price;

    private Double pledged_share;

    private LocalDateTime stock_date;

    private Double income_tax;

    private Double resident_tax;

    private LocalDateTime first_paydate;

    private LocalDateTime second_paydate;

    private String place;

}
