package com.example.baedang_backend.domain.stock.model;

import com.example.baedang_backend.domain.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Stock extends BaseEntity {

    @Id
    @Column(name="stock_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String stock_name;

    private String image_url;
}
