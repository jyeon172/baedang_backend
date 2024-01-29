package com.example.baedang_backend.domain.member.api;

import com.example.baedang_backend.domain.member.application.MemberStockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.baedang_backend.domain.member.dto.MemeberStockDto.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberStockController {

    private final MemberStockService memberStockService;

    @GetMapping(value="/api/stock/{user_id}")
    public List<MemberStockListDto> findStocksByMemberId(@PathVariable Long user_id) {
        List<MemberStockListDto> stockList = memberStockService.findHoldStocksByMemberId(user_id);

        return stockList;
    }

    @PostMapping(value="/api/stock/{user_id}")
    public AddStockResponseDto addMemberStock(@PathVariable Long user_id, @RequestBody AddStockRequestDto addStockRequestDto) {
        AddStockResponseDto addStock = memberStockService.addMemberStock(user_id, addStockRequestDto);

        return addStock;
    }
}
