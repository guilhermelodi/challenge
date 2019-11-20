package br.com.estudo.storechallenge.challenge.controller;

import br.com.estudo.storechallenge.challenge.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService service;

}
