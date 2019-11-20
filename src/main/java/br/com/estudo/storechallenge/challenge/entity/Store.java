package br.com.estudo.storechallenge.challenge.entity;

import lombok.Data;

import java.util.List;

@Data
//@Entity
public class Store {

    private String name;

    private String address;

    private List<Order> orders;

}
