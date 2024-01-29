package com.example.baedang_backend.domain.member.dto;

import com.example.baedang_backend.domain.member.model.Member;
import com.example.baedang_backend.domain.member.model.MemberStock;
import com.example.baedang_backend.domain.stock.model.Stock;
import com.example.baedang_backend.domain.stock.model.StockDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class MemeberStockDto {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberStockListDto {
        private Long stock_id;

        private String stock_name;

        private Double stock_holding;

        @Enumerated(EnumType.STRING)
        private StockDomain stock_domain;

        public void setStock_id(Long stock_id) {
            this.stock_id = stock_id;
        }

        public void setStock_name(String stock_name) {
            this.stock_name = stock_name;
        }

        public void setStock_domain(StockDomain stock_domain) {
            this.stock_domain = stock_domain;
        }

        public void setStock_holding(Double stock_holding) {
            this.stock_holding = stock_holding;
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddStockRequestDto {

        private Long stock_id;

        public MemberStock toEntity(Stock stock, Member member) {
            return MemberStock.builder()
                    .member(member)
                    .stock(stock)
                    .stock_domain(StockDomain.INTEREST)
                    .holding((double) 0)
                    .build();
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddStockResponseDto {
        private Long stock_id;

        private String stock_name;

        @Enumerated(EnumType.STRING)
        private StockDomain stock_domain;

        public AddStockResponseDto toResponseDto(MemberStock memberStock) {
            return AddStockResponseDto.builder()
                    .stock_id(memberStock.getStock().getId())
                    .stock_name(memberStock.getStock().getStock_name())
                    .stock_domain(memberStock.getStock_domain())
                    .build();
        }
    }
}
