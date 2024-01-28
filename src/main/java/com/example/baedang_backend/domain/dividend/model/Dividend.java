package com.example.baedang_backend.domain.dividend.model;

import com.example.baedang_backend.domain.stock.model.Stock;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@NoArgsConstructor
public class Dividend {
    @Id
    @Column(name = "dividend_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id")
    private Stock stock;

    private Double price;

    private LocalDateTime base_Date;

    private LocalDateTime payment_date;

    private Double tendency;

    private Double rate;

}
