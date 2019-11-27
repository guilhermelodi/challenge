package br.com.estudo.storechallenge.order.controller;

import br.com.estudo.storechallenge.order.entity.Order;
import br.com.estudo.storechallenge.order.response.OrderResponse;
import br.com.estudo.storechallenge.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "Order", tags = "Order")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping(value = "orders")
    @ApiOperation(value = "Lists all orders")
    public ResponseEntity<List<OrderResponse>> listAllOrders() {
        return new ResponseEntity<>(service.listAllOrders(), HttpStatus.OK);
    }

    @ApiOperation(value = "Gets one order by user")
    @GetMapping(value = "users/{user}/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderResponse>> findOrdersByUser(@PathVariable String user) {
        return new ResponseEntity<>(service.listOrdersByUser(user), HttpStatus.OK);
    }

}
