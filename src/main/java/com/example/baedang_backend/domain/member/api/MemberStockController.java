package com.example.baedang_backend.domain.member.api;

import com.example.baedang_backend.domain.member.application.MemberStockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.baedang_backend.domain.stock.dto.StockDto.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberStockController {

    private final MemberStockService memberStockService;

    @GetMapping(value="/api/{user_id}/list")
    public List<StockListDto> findStocksByMemberId(@PathVariable Long user_id) {
        List<StockListDto> stockList = memberStockService.findStocksByMemberId(user_id);

        return stockList;
    }
}
