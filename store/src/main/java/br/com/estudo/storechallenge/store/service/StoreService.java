package br.com.estudo.storechallenge.store.service;

import br.com.estudo.storechallenge.store.entity.Store;
import br.com.estudo.storechallenge.store.exception.StoreNotFoundException;
import br.com.estudo.storechallenge.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public List<Store> listAllStores() {
        return storeRepository.findAll();
    }

    public Store findStoreById(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(StoreNotFoundException::new);
    }

}