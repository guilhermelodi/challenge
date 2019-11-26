package br.com.estudo.storechallenge.store.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "store")
public class Store {

    @Id
    private Long id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "store")
    private List<Order> orders;

    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "update_date")
    private Date updateDate;

}
