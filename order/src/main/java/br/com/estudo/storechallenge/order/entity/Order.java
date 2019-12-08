package br.com.estudo.storechallenge.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"order\"")
@EntityListeners(AuditingEntityListener.class)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "\"user\"")
    private String user;

    private String address;

    @Column(name = "confirmation_date")
    private LocalDateTime confirmationDate;

    // TODO: criar enum StatusOrder
    private Integer status;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;

    @Column(name = "payment_id")
    private Long paymentId;

    @CreatedDate
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @LastModifiedDate
    @Column(name = "update_date")
    private LocalDateTime updateDate;

}
