package com.example.baedang_backend.domain.member.application;

import com.example.baedang_backend.domain.member.dao.MemberRepository;
import com.example.baedang_backend.domain.member.dao.MemberStockRepository;
import com.example.baedang_backend.domain.member.dto.MemeberStockDto.MemberStockListDto;
import com.example.baedang_backend.domain.member.model.Member;
import com.example.baedang_backend.domain.member.model.MemberStock;
import com.example.baedang_backend.domain.stock.dao.StockRepository;
import com.example.baedang_backend.domain.stock.model.Stock;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.baedang_backend.domain.member.dto.MemeberStockDto.*;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberStockService {
    private final MemberStockRepository memberStockRepository;

    private final StockRepository stockRepository;

    private final MemberRepository memberRepository;


    public List<MemberStockListDto> findHoldStocksByMemberId(Long memberId) {
        List<MemberStock> memberStockList = memberStockRepository.findStocksByMemberId(memberId);
        List<MemberStockListDto> stockList = memberStockList.stream().map(memberStock -> {
            Stock stock = memberStock.getStock();
            MemberStockListDto memberStockListDto = new MemberStockListDto();
            memberStockListDto.setStock_id(stock.getId());
            memberStockListDto.setStock_name(stock.getStock_name());
            memberStockListDto.setStock_domain(memberStock.getStock_domain());
            memberStockListDto.setStock_holding(memberStock.getHolding());
            return memberStockListDto;
        }).collect(Collectors.toList());

        return stockList;
    }

    @Transactional
    public AddStockResponseDto addMemberStock(Long memberId, AddStockRequestDto addStockRequestDto) {
        Stock stock = stockRepository.findById(addStockRequestDto.getStock_id()).orElseThrow();

        Member member = memberRepository.findById(memberId).orElseThrow();

        MemberStock newStock = addStockRequestDto.toEntity(stock, member);
        MemberStock savedMember = memberStockRepository.save(newStock);

        return new AddStockResponseDto().toResponseDto(savedMember);
    }
}
