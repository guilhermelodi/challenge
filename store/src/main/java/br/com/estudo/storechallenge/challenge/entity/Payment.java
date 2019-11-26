package br.com.estudo.storechallenge.challenge.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    private Long id;

    @Column(name = "credit_card_number")
    private Integer creditCardNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "payment_date")
    private Date paymentDate;

    // TODO: criar enum StatusPayment
    private Integer status;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "order_id", nullable = true)
    private Order order;

    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "update_date")
    private Date updateDate;

}
