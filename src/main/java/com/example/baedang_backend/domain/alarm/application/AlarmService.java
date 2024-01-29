package com.example.baedang_backend.domain.alarm.application;

import com.example.baedang_backend.domain.alarm.dao.AlarmRepository;
import com.example.baedang_backend.domain.alarm.dto.AlarmDto;
import com.example.baedang_backend.domain.alarm.dto.AlarmDto.AlarmListDto;
import com.example.baedang_backend.domain.alarm.model.Alarm;
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
public class AlarmService {

    private final AlarmRepository alarmRepository;

    public List<AlarmListDto> findAlarmsByMemberId(Long member_id) {
        List<Alarm> alarmList = alarmRepository.findAlarmsByMemberId(member_id);
        List<AlarmListDto> collects = alarmList.stream().map(alarm -> {
            AlarmListDto alarmListDto = new AlarmListDto();
            alarmListDto.setAlarm_id(alarm.getId());
            alarmListDto.setAlarm_domain(alarm.getAlarm_domain());
            alarmListDto.setMessage(alarm.getMessage());
            alarmListDto.setMember_stock_id(alarm.getMemberStock().getId());
            return alarmListDto;
        }).collect(Collectors.toList());

        return collects;
    }
}
