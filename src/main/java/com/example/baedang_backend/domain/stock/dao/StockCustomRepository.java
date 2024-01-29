package com.example.baedang_backend.domain.stock.dao;

import com.example.baedang_backend.domain.stock.model.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StockCustomRepository {
    Page<Stock> findStockByName(String stock_name, Pageable pageable);

}
