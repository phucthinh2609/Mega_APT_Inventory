package com.cg.repository;

import com.cg.model.dto.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatisticsRepository {
    @Query("SELECT new com.cg.model.dto.Statistics (" +
            "COUNT(ord), " +
            "SUM(ord.quantityTotal), " +
            "SUM(ord.totalAmount)" +
            ") " +
            "FROM Order AS ord " +
            "WHERE DATE(ord.deliveryDate) >= ?1 "
    )
    Optional<Statistics> getRevenueStatisticsByTime(String time);
}
