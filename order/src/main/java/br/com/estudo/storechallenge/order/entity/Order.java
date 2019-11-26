package br.com.estudo.storechallenge.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "\"order\"")
public class Order {

    @Id
    private Long id;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "\"user\"")
    private String user;

    private String address;

    @Temporal(TemporalType.DATE)
    @Column(name = "confirmation_date")
    private Date confirmationDate;

    // TODO: criar enum StatusOrder
    private Integer status;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;

    @Column(name = "payment_id")
    private Long paymentId;

    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "update_date")
    private Date updateDate;

}
