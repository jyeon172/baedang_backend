package com.example.baedang_backend.domain.alarm.dto;

import com.example.baedang_backend.domain.alarm.model.AlarmDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class AlarmDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AlarmListDto {

        private Long alarm_id;

        private Long member_stock_id;

        @Enumerated(EnumType.STRING)
        private AlarmDomain alarm_domain;

        public void setAlarm_id(Long alarm_id) {
            this.alarm_id = alarm_id;
        }

        private String message;

        public void setMember_stock_id(Long member_stock_id) {
            this.member_stock_id = member_stock_id;
        }

        public void setAlarm_domain(AlarmDomain alarm_domain) {
            this.alarm_domain = alarm_domain;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
