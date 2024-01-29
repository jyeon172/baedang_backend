package com.example.baedang_backend.domain.stock.dao;

import com.example.baedang_backend.domain.stock.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long>, StockCustomRepository {
    Optional<Stock> findById(Long id);

//    Optional<Stock> findByName(String stock_name);
}
