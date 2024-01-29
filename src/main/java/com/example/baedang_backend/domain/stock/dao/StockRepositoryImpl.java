package com.example.baedang_backend.domain.stock.dao;

import com.example.baedang_backend.domain.stock.model.Stock;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

import static com.example.baedang_backend.domain.stock.model.QStock.stock;


@RequiredArgsConstructor
@Slf4j
public class StockRepositoryImpl implements StockCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Stock> findStockByName(String stock_name, Pageable pageable) {
        List<Stock> results = findStockByNameQuery(stock_name, pageable);

        JPAQuery<Long> countQuery = jpaQueryFactory
                .select(stock.count())
                .from(stock)
                .where(stock.stock_name.contains(stock_name));

        return PageableExecutionUtils.getPage(results, pageable, countQuery::fetchOne);
    }

    public List<Stock> findStockByNameQuery(String name, Pageable pageable) {
        List<Stock> results = jpaQueryFactory
                .selectFrom(stock)
                .where(stock.stock_name.contains(name))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return results;
    }
}
