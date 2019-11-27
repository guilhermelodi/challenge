package br.com.estudo.storechallenge.order.service;

import br.com.estudo.storechallenge.order.client.StoreClient;
import br.com.estudo.storechallenge.order.entity.Order;
import br.com.estudo.storechallenge.order.response.OrderResponse;
import br.com.estudo.storechallenge.order.response.StoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private StoreClient storeClient;

    // Lista fixa enquanto não tenho banco de dados
    private List<Order> orderList = Arrays.asList(
            Order.builder()
                    .id(1L)
                    .storeId(1L)
                    .address("Rua Palestra Itália, 214")
                    .confirmationDate(new Date())
                    .status(3)
                    .build(),
            Order.builder()
                    .id(2L)
                    .storeId(2L)
                    .address("Rua Turiassú, 1350")
                    .confirmationDate(new Date())
                    .status(5)
                    .build()
    );

    public List<OrderResponse> listAllOrders() {
        return orderList.stream()
                .map(o -> {
                    OrderResponse orderResponse = OrderResponse.fromEntity(o);

                    StoreResponse storeResponse = storeClient.findStoreById(o.getId());
                    orderResponse.setStore(storeResponse);

                    return orderResponse;
                })
                .collect(Collectors.toList());
    }

    public List<OrderResponse> listOrdersByUser(String user) {
        return orderList.stream()
                .map(o -> {
                    OrderResponse orderResponse = OrderResponse.fromEntity(o);

                    StoreResponse storeResponse = storeClient.findStoreById(o.getId());
                    orderResponse.setStore(storeResponse);

                    return orderResponse;
                })
                .collect(Collectors.toList());
    }

}