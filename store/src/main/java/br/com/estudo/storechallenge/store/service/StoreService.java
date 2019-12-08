package br.com.estudo.storechallenge.store.service;

import br.com.estudo.storechallenge.store.entity.Store;
import br.com.estudo.storechallenge.store.exception.StoreNotFoundException;
import br.com.estudo.storechallenge.store.repository.StoreRepository;
import br.com.estudo.storechallenge.store.request.StoreRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Store add(StoreRequest storeRequest) {
        log.info("Adding new store. Name: {}", storeRequest.getName());

        Store store = new Store();
        store.copyFromRequest(storeRequest);

        return storeRepository.save(store);
    }

    public Store update(Long id, StoreRequest storeRequest) {
        log.info("Updating store by ID: {}", id);

        Store store = findStoreById(id);
        store.copyFromRequest(storeRequest);

        return storeRepository.save(store);
    }

    public void delete(Long id) {
        log.info("Deleting store by ID: {}", id);

        storeRepository.delete(findStoreById(id));
    }
}