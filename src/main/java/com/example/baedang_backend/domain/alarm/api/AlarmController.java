package com.example.baedang_backend.domain.alarm.api;

import com.example.baedang_backend.domain.alarm.application.AlarmService;
import com.example.baedang_backend.domain.alarm.dto.AlarmDto.AlarmListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
public class AlarmController {


    private final AlarmService alarmService;

    @GetMapping("/api/alarm/{member_id}")
    public List<AlarmListDto> findAlarmsByMemberId(@PathVariable Long member_id) {
        List<AlarmListDto> alarmList = alarmService.findAlarmsByMemberId(member_id);

        return alarmList;
    }
}
