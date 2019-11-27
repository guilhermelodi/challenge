package br.com.estudo.storechallenge.order.dao;

import br.com.estudo.storechallenge.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {

    List<Order> findByUser(String user);

}
