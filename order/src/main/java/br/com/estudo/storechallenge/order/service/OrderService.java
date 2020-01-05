package br.com.estudo.storechallenge.order.service;

import br.com.estudo.storechallenge.order.client.StoreClient;
import br.com.estudo.storechallenge.order.entity.Order;
import br.com.estudo.storechallenge.order.repository.OrderRepository;
import br.com.estudo.storechallenge.order.response.OrderResponse;
import br.com.estudo.storechallenge.order.response.StoreResponse;
import br.com.estudo.storechallenge.order.response.StoreTotalSalesResponse;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private StoreClient storeClient;

    public List<OrderResponse> listAllOrders() {
        log.info("Listing all orders");

        List<Order> orders = orderRepository.findAll();

        return orders.stream()
                .map(o -> {
                    OrderResponse orderResponse = OrderResponse.fromEntity(o);

                    StoreResponse storeResponse = findStoreById(o.getStoreId());
                    orderResponse.setStore(storeResponse);

                    return orderResponse;
                })
                .collect(Collectors.toList());
    }

    public List<OrderResponse> listOrdersByUser(String user) {
        log.info("Listing orders by user: {}", user);

        List<Order> orders = orderRepository.findByUser(user);

        return orders.stream()
                .map(o -> {
                    OrderResponse orderResponse = OrderResponse.fromEntity(o);

                    StoreResponse storeResponse = findStoreById(o.getStoreId());
                    orderResponse.setStore(storeResponse);

                    return orderResponse;
                })
                .collect(Collectors.toList());
    }

    public StoreTotalSalesResponse findTotalSalesByStoreId(Long storeId) {
        log.info("Calculating the total sales to store: {}", storeId);

        LocalDate today = LocalDate.now();
        LocalDateTime startDate = today.withDayOfMonth(1).atStartOfDay();
        LocalDateTime endDate = today.with(TemporalAdjusters.lastDayOfMonth()).atTime(LocalTime.MAX);

        StoreTotalSalesResponse storeTotalSalesResponse = StoreTotalSalesResponse.builder()
                .storeId(storeId)
                .totalDay(orderRepository.sumTotalSalesByStoreIdAndIntervalDates(storeId,
                            today.atStartOfDay(), today.atTime(LocalTime.MAX))
                        .orElse(new BigDecimal("0")))
                .totalMonth(orderRepository.sumTotalSalesByStoreIdAndIntervalDates(storeId,
                            startDate, endDate)
                        .orElse(new BigDecimal("0")))
                .build();

        return storeTotalSalesResponse;
    }

    private StoreResponse findStoreById(Long id) {
        try {
            return storeClient.findStoreById(id);
        } catch (FeignException e) {
            if (e.status() == 404) {
                return StoreResponse.builder()
                        .id(id)
                        .description("Store do not found.")
                        .build();
            } else {
                return StoreResponse.builder()
                        .id(id)
                        .build();
            }
        } catch (Exception e) {
            return null;
        }
    }
}