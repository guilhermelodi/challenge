package br.com.estudo.storechallenge.order.repository;

import br.com.estudo.storechallenge.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(String user);

    @Query("SELECT SUM(oi.quantity * oi.unitPrice) " +
            " FROM OrderItem oi " +
            " WHERE TO_CHAR(oi.order.creationDate, 'MM/YYYY') = :month " +
            "  AND oi.order.storeId = :storeId")
    Optional<BigDecimal> sumTotalSalesByStoreIdAndMonth(Long storeId, String month);

    @Query("SELECT SUM(oi.quantity * oi.unitPrice) " +
            " FROM OrderItem oi " +
            " WHERE TO_CHAR(oi.order.creationDate, 'DD/MM/YYYY') = :day " +
            "  AND oi.order.storeId = :storeId")
    Optional<BigDecimal> sumTotalSalesByStoreIdAndDay(Long storeId, String day);

}
