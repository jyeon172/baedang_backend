package com.example.baedang_backend.domain.notice.api;

import com.example.baedang_backend.domain.notice.application.NoticeService;
import com.example.baedang_backend.domain.notice.dto.NoticeDto;
import com.example.baedang_backend.domain.notice.dto.NoticeDto.NoticeListDto;
import com.example.baedang_backend.domain.notice.dto.NoticeDto.OneNoticeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping(value="/api/notice/list/{user_id}/{stock_id}")
    public List<NoticeListDto> findMemberNoticesByStockId(@PathVariable(name="user_id") Long user_id, @PathVariable(name="stock_id") Long stock_id) {
        List<NoticeListDto> noticeList = noticeService.findMemberNoticesByStockId(user_id, stock_id);

        return noticeList;
    }

    @GetMapping(value="/api/notice/{notice_id}")
    public OneNoticeDto findNotice(@PathVariable(name="notice_id") Long notice_id) {
        OneNoticeDto notice = noticeService.getNotice(notice_id);

        return notice;
    }
}
