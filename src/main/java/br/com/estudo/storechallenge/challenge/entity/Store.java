package br.com.estudo.storechallenge.challenge.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
//@Entity
public class Store {

    private Long id;

    private String name;

    private String address;

    private List<Order> orders;

}
