package br.com.estudo.storechallenge.store.dao;

import br.com.estudo.storechallenge.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreDAO extends JpaRepository<Store, Long> {
}
