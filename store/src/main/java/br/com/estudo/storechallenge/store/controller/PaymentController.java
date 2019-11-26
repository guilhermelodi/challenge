package br.com.estudo.storechallenge.store.controller;

import br.com.estudo.storechallenge.store.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService service;

}