package br.com.estudo.storechallenge.order.service;

import br.com.estudo.storechallenge.order.client.StoreClient;
import br.com.estudo.storechallenge.order.dao.OrderDAO;
import br.com.estudo.storechallenge.order.entity.Order;
import br.com.estudo.storechallenge.order.response.OrderResponse;
import br.com.estudo.storechallenge.order.response.StoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderDAO dao;

    @Autowired
    private StoreClient storeClient;

    public List<OrderResponse> listAllOrders() {
        List<Order> orders = dao.findAll();

        return orders.stream()
                .map(o -> {
                    OrderResponse orderResponse = OrderResponse.fromEntity(o);

                    StoreResponse storeResponse = storeClient.findStoreById(o.getId());
                    orderResponse.setStore(storeResponse);

                    return orderResponse;
                })
                .collect(Collectors.toList());
    }

    public List<OrderResponse> listOrdersByUser(String user) {
        List<Order> orders = dao.findByUser(user);

        return orders.stream()
                .map(o -> {
                    OrderResponse orderResponse = OrderResponse.fromEntity(o);

                    StoreResponse storeResponse = storeClient.findStoreById(o.getId());
                    orderResponse.setStore(storeResponse);

                    return orderResponse;
                })
                .collect(Collectors.toList());
    }

}