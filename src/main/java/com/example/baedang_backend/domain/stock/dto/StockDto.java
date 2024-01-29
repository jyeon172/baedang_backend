package com.example.baedang_backend.domain.stock.dto;

import com.example.baedang_backend.domain.stock.model.Stock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StockDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StockResponseDto {
        private Long stock_id;

        private String stock_name;

        public void setStock_id(Long stock_id) {
            this.stock_id = stock_id;
        }

        public void setStock_name(String stock_name) {
            this.stock_name = stock_name;
        }
    }

}
