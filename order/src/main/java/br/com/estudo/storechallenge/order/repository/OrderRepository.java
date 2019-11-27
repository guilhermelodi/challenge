package br.com.estudo.storechallenge.order.repository;

import br.com.estudo.storechallenge.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(String user);

}
