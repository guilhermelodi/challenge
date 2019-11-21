package br.com.estudo.storechallenge.challenge.controller;

import br.com.estudo.storechallenge.challenge.entity.Order;
import br.com.estudo.storechallenge.challenge.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> listAllOrders() {
        return new ResponseEntity<>(service.listAllOrders(), HttpStatus.OK);
    }

}
