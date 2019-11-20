package br.com.estudo.storechallenge.challenge.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
//@Entity
public class Payment {

    private Integer creditCardNumber;

    // TODO: verificar com o Uri a utilização do LocalDate
    private Date paymentDate;

    // TODO: criar enum StatusPayment
    private Integer status;

    @JsonIgnore
    private Order order;

}
