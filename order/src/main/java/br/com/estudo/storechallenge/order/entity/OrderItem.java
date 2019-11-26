package br.com.estudo.storechallenge.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    private Long id;

    private String description;

    @Column(name = "unit_price")
    private Double unitPrice;

    private Integer quantity;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "update_date")
    private Date updateDate;

}
