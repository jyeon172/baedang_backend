package com.example.baedang_backend.domain.notice.dto;

import com.example.baedang_backend.domain.member.model.MemberStock;
import com.example.baedang_backend.domain.notice.model.Notice;
import com.example.baedang_backend.domain.stock.model.StockType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class NoticeDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class NoticeListDto {
        private Long id;

        private String stock_name;

        private LocalDateTime payment_period;

        public void setId(Long id) {
            this.id = id;
        }

        public void setStock_name(MemberStock memberStock) {
            this.stock_name = memberStock.getStock().getStock_name();
        }

        public void setPayment_period(LocalDateTime payment_period) {
            this.payment_period = payment_period;
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OneNoticeDto {
        private Long id;

        private String stock_name;

        private LocalDateTime payment_period;

        private LocalDateTime base_date;

        private Long member_num;

        @Enumerated(EnumType.STRING)
        private StockType stock_type;

        private Double cash_rate;

        private Double stock_rate;

        private Double short_holding;

        private Double cash_price;

        private Double stock_price;

        private Double pledged_share;

        private LocalDateTime stock_date;

        private Double income_tax;

        private Double resident_tax;

        private LocalDateTime first_paydate;

        private LocalDateTime second_paydate;

        private String place;

        public OneNoticeDto toResponseDto(Notice notice) {
            return OneNoticeDto.builder()
                    .id(notice.getId())
                    .stock_name(notice.getMemberStock().getStock().getStock_name())
                    .payment_period(notice.getPayment_period())
                    .base_date(notice.getBase_date())
                    .member_num(notice.getMember_num())
                    .stock_type(notice.getStock_type())
                    .cash_rate(notice.getCash_rate())
                    .stock_rate(notice.getStock_rate())
                    .short_holding(notice.getShort_holding())
                    .cash_price(notice.getCash_price())
                    .stock_price(notice.getStock_price())
                    .pledged_share(notice.getPledged_share())
                    .stock_date(notice.getStock_date())
                    .income_tax(notice.getIncome_tax())
                    .resident_tax(notice.getResident_tax())
                    .first_paydate(notice.getFirst_paydate())
                    .second_paydate(notice.getSecond_paydate())
                    .place(notice.getPlace())
                    .build();
        }
    }
}
