package br.com.estudo.storechallenge.store.repository;

import br.com.estudo.storechallenge.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
