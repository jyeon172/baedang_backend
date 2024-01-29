package com.example.baedang_backend.domain.stock.api;

import com.example.baedang_backend.domain.stock.application.StockService;
import com.example.baedang_backend.domain.stock.dto.StockDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import static com.example.baedang_backend.domain.stock.dto.StockDto.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/api/stock/list")
    public Page<StockResponseDto> searchStock(@RequestParam(value = "search", required = false, defaultValue = "") String stock_name, Pageable pageable) throws JsonProcessingException {
        Page<StockResponseDto> stockList = stockService.findStockByName(stock_name, pageable);

        return stockList;
    }
}
