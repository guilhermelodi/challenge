package br.com.estudo.storechallenge.challenge.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
//@Entity
public class Order {

    private Long id;

    @JsonIgnore
    private Store store;

    private String address;

    // TODO: verificar com o Uri a utilização do LocalDate
    private Date confirmationDate;

    // TODO: criar enum StatusOrder
    private Integer status;

    private List<OrderItem> items;

    private Payment payment;

}
