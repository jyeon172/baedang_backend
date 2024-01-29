package com.example.baedang_backend.domain.stock.application;

import com.example.baedang_backend.domain.stock.dao.StockRepositoryImpl;
import com.example.baedang_backend.domain.stock.dto.StockDto.StockResponseDto;
import com.example.baedang_backend.domain.stock.model.Stock;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StockService {

    private final StockRepositoryImpl stockRepositoryImpl;

    public Page<StockResponseDto> findStockByName(String stock_name, Pageable pageable) {
        log.info("here");
        Page<Stock> stockList = stockRepositoryImpl.findStockByName(stock_name, pageable);
        Page<StockResponseDto> collect = stockList.map(stock -> {
            StockResponseDto stockListDto = new StockResponseDto();
            stockListDto.setStock_id(stock.getId());
            stockListDto.setStock_name(stock.getStock_name());
            return stockListDto;
        });

        return collect;
    }
}
