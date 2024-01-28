package com.example.baedang_backend.domain.member.model;


import com.example.baedang_backend.domain.stock.model.Stock;
import com.example.baedang_backend.domain.stock.model.StockDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberStock {

    @Id
    @Column(name = "member_stock_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @Enumerated(EnumType.STRING)
    private StockDomain stock_domain;

    private Double holding;
}
