package com.example.baedang_backend.domain.notice.application;

import com.example.baedang_backend.domain.notice.dao.NoticeRepository;
import com.example.baedang_backend.domain.notice.dto.NoticeDto;
import com.example.baedang_backend.domain.notice.model.Notice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.baedang_backend.domain.notice.dto.NoticeDto.*;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public List<NoticeListDto> findMemberNoticesByStockId(Long user_id, Long stock_id) {
        List<Notice> noticeList = noticeRepository.findMemberNoticesByStockId(user_id, stock_id);
        List<NoticeListDto> collects = noticeList.stream().map(notice -> {
            NoticeListDto noticeListDto = new NoticeListDto();
            noticeListDto.setId(notice.getId());
            noticeListDto.setStock_name(notice.getMemberStock());
            noticeListDto.setPayment_period(notice.getPayment_period());
            return noticeListDto;
        }).collect(Collectors.toList());

        return collects;
    }

    public OneNoticeDto getNotice(Long notice_id) {
        Notice notice = noticeRepository.findById(notice_id).orElseThrow();

        return new OneNoticeDto().toResponseDto(notice);
    }
}
