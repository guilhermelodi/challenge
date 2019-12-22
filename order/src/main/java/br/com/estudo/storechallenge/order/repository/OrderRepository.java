package br.com.estudo.storechallenge.order.repository;

import br.com.estudo.storechallenge.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(String user);

    @Query("SELECT SUM(oi.quantity * oi.unitPrice) " +
            " FROM OrderItem oi " +
            " WHERE MONTH(oi.order.creationDate) = MONTH(current_date) " +
            "  AND oi.order.storeId =  :storeId")
    Optional<BigDecimal> sumTotalSalesMonthByStoreId(Long storeId);

    @Query("SELECT SUM(oi.quantity * oi.unitPrice) " +
            " FROM OrderItem oi " +
            " WHERE DAY(oi.order.creationDate) = DAY(current_date) " +
            "  AND oi.order.storeId =  :storeId")
    Optional<BigDecimal> sumTotalSalesDayByStoreId(Long storeId);

}
