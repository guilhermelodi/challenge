package br.com.estudo.storechallenge.store.service;

import br.com.estudo.storechallenge.store.dao.StoreDAO;
import br.com.estudo.storechallenge.store.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreDAO dao;

    public List<Store> listAllStores() {
        return dao.findAll();
    }

    public Optional<Store> findStoreById(Long id) {
        return dao.findById(id);
    }

}