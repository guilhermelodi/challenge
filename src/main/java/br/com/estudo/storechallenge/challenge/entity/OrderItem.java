package br.com.estudo.storechallenge.challenge.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
//@Entity
public class OrderItem {

    private String description;

    private Double unitPrice;

    private Integer quantity;

    @JsonIgnore
    private Order order;

}
