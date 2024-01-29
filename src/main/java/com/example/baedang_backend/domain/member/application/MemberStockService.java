package com.example.baedang_backend.domain.member.application;

import com.example.baedang_backend.domain.member.dao.MemberStockRepository;
import com.example.baedang_backend.domain.member.model.MemberStock;
import com.example.baedang_backend.domain.stock.dto.StockDto.StockListDto;
import com.example.baedang_backend.domain.stock.model.Stock;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberStockService {
    private final MemberStockRepository memberStockRepository;


    public List<StockListDto> findStocksByMemberId(Long memberId) {
        List<MemberStock> memberStockList = memberStockRepository.findStocksByMemberId(memberId);
        List<StockListDto> stockList = memberStockList.stream().map(memberStock -> {
            Stock stock = memberStock.getStock();
            StockListDto stockListDto = new StockListDto();
            stockListDto.setStock_id(stock.getId());
            stockListDto.setStock_name(stock.getStock_name());
            return stockListDto;
        }).collect(Collectors.toList());

        return stockList;
    }
}
