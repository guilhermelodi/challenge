package br.com.estudo.storechallenge.store.controller;

import br.com.estudo.storechallenge.store.entity.Order;
import br.com.estudo.storechallenge.store.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orders")
@Api(value = "Order", tags = "Order")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    @ApiOperation(value = "Lists all orders")
    public ResponseEntity<List<Order>> listAllOrders() {
        return new ResponseEntity<>(service.listAllOrders(), HttpStatus.OK);
    }

}
