package com.cg.repository;

import com.cg.model.InventoryDetail;
import com.cg.model.dto.InventoryDetailDTO;
import com.cg.model.dto.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryDetailRepository extends JpaRepository<InventoryDetail, String> {

    @Query("SELECT new com.cg.model.dto.InventoryDetailDTO (" +
            "inDe.stockInDate, " +
            "p.title, " +
            "inDe.stockInPrice, " +
            "COUNT(inDe.product) " +
        ") " +
        "FROM InventoryDetail AS inDe, Product AS p " +
        "WHERE inDe.product.id = ?1 " +
        "AND inDe.selled = false " +
        "AND inDe.product.id = p.id " +
        "GROUP BY inDe.stockInDate " +
        "ORDER BY inDe.stockInDate"
    )
    List<InventoryDetailDTO> getProductDetail(String productId);

    @Query("SELECT " +
                "COUNT(inDe) " +
            "FROM InventoryDetail AS inDe " +
            "WHERE inDe.selled = false "
    )
    int getInventoryTotalQuantity();

    @Query("SELECT " +
            "SUM(inDe.stockInPrice) " +
            "FROM InventoryDetail AS inDe " +
            "WHERE inDe.selled = false "
    )
    BigDecimal getInventoryTotalAmount();

//    @Query("SELECT " +
//            "COUNT(inDe) " +
//            "FROM InventoryDetail AS inDe " +
//            "WHERE inDe.product.title LIKE  %?1% " +
//            "AND inDe.selled = false "
//    )
//    int getQuantityOfGroup(String group);

//    @Query(value = "SELECT new com.cg.model.dto.InventoryDetailDTO (" +
//                "p.brand, " +
//                "COUNT(inDe.product.brand) " +
//                ") " +
//            "FROM InventoryDetail AS inDe, Product AS p " +
//            "WHERE inDe.product.id = p.id " +
//            "AND inDe.selled = false " +
//            "GROUP BY inDe.product.brand "
//    )
//    List<InventoryDetailDTO> getInventoryGroupByBrand();
//
//    @Query(value = "SELECT new com.cg.model.dto.InventoryDetailDTO (" +
//                "p.model, " +
//                "COUNT(inDe.product.model) " +
//                ") " +
//            "FROM InventoryDetail AS inDe, Product AS p " +
//            "WHERE inDe.product.id = p.id " +
//            "AND inDe.selled = false " +
//            "GROUP BY inDe.product.model "
//    )
//    List<InventoryDetailDTO> getInventoryGroupByModel();
//
//    @Query(value = "SELECT new com.cg.model.dto.InventoryDetailDTO (" +
//                "COUNT(inDe) " +
//                ") " +
//            "FROM InventoryDetail AS inDe " +
//            "WHERE inDe.product.title LIKE  %:core% " +
//            "AND inDe.selled = false "
//    )
//    List<InventoryDetailDTO> getInventoryGroupByCore(@Param("core") String core);
//
//    @Query(value = "SELECT new com.cg.model.dto.InventoryDetailDTO (" +
//                "p.title, " +
//                "COUNT(inDe.product) " +
//                ") " +
//            "FROM InventoryDetail AS inDe, Product AS p " +
//            "WHERE inDe.product.id = p.id " +
//            "AND inDe.selled = false " +
//            "GROUP BY inDe.product "
//    )
//    List<InventoryDetailDTO> getInventoryGroupByRam();
//
//    @Query(value = "SELECT new com.cg.model.dto.InventoryDetailDTO (" +
//                "p.title, " +
//                "COUNT(inDe.product) " +
//                ") " +
//            "FROM InventoryDetail AS inDe, Product AS p " +
//            "WHERE inDe.product.id = p.id " +
//            "AND inDe.selled = false " +
//            "GROUP BY inDe.product "
//    )
//    List<InventoryDetailDTO> getInventoryGroupByCapacity();

    @Query("SELECT new com.cg.model.dto.InventoryDetailDTO (" +
            "inDe.stockInDate, " +
            "p.title, " +
            "inDe.stockInPrice, " +
            "COUNT(inDe.product) " +
        ") " +
        "FROM InventoryDetail AS inDe, Product AS p " +
        "WHERE inDe.product.id = p.id " +
        "AND inDe.selled = false " +
        "GROUP BY inDe.product, inDe.stockInDate " +
        "ORDER BY inDe.stockInDate"
    )
    List<InventoryDetailDTO> getAllInventoryDetails();

    @Query("SELECT new com.cg.model.dto.Statistics (" +
            "inDe.stockInDate, " +
            "p.title, " +
            "inDe.stockInPrice, " +
            "COUNT(inDe.product) " +
            ") " +
            "FROM InventoryDetail AS inDe, Product AS p " +
            "WHERE inDe.product.id = p.id " +
            "AND inDe.selled = false " +
            "GROUP BY inDe.product, inDe.stockInDate " +
            "ORDER BY inDe.stockInDate"
    )
    Optional<Statistics> getStatisticsByTime(String startTime);


}
