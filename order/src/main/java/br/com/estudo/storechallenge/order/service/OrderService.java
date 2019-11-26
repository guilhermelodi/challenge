package br.com.estudo.storechallenge.order.service;

import br.com.estudo.storechallenge.order.entity.Order;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    // Lista fixa enquanto não tenho banco de dados
    private List<Order> orderList = Arrays.asList(
            Order.builder()
                    .id(1L)
                    .address("Rua Palestra Itália, 214")
                    .confirmationDate(new Date())
                    .status(3)
                    .build(),
            Order.builder()
                    .id(2L)
                    .address("Rua Turiassú, 1350")
                    .confirmationDate(new Date())
                    .status(5)
                    .build()
    );

    public List<Order> listAllOrders() {
        return orderList;
    }

}