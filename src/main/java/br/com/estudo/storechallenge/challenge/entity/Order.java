package br.com.estudo.storechallenge.challenge.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
//@Entity
public class Order {

    private String address;

    // TODO: verificar com o Uri a utilização do LocalDate
    private Date confirmationDate;

    // TODO: criar enum StatusOrder
    private Integer status;

    private List<OrderItem> items;

}
