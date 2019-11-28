package br.com.estudo.storechallenge.store.service;

import br.com.estudo.storechallenge.store.entity.Store;
import br.com.estudo.storechallenge.store.exception.StoreNotFoundException;
import br.com.estudo.storechallenge.store.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public List<Store> listAllStores() {
        log.info("Listing all stores");

        return storeRepository.findAll();
    }

    public Store findStoreById(Long id) {
        log.info("Finding store by ID: {}", id);

        return storeRepository.findById(id)
                .orElseThrow(StoreNotFoundException::new);
    }

}