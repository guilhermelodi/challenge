package br.com.estudo.storechallenge.order.repository;

import br.com.estudo.storechallenge.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(String user);

    @Query("SELECT SUM(oi.quantity * oi.unitPrice) " +
            " FROM OrderItem oi " +
            " WHERE oi.order.creationDate BETWEEN :startDate AND :endDate " +
            "  AND oi.order.storeId = :storeId")
    Optional<BigDecimal> sumTotalSalesByStoreIdAndIntervalDates(Long storeId,
                                                                LocalDateTime startDate,
                                                                LocalDateTime endDate);

}
