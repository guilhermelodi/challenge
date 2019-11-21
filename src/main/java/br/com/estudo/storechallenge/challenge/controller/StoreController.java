package br.com.estudo.storechallenge.challenge.controller;

import br.com.estudo.storechallenge.challenge.entity.Order;
import br.com.estudo.storechallenge.challenge.entity.Store;
import br.com.estudo.storechallenge.challenge.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("stores")
public class StoreController {

    @Autowired
    private StoreService service;

    @GetMapping
    public ResponseEntity<List<Store>> listAllStores() {
        return new ResponseEntity<>(service.listAllStores(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> findStoreById(@PathVariable Long id) {
        Optional<Store> optionalStore = service.findStoreById(id);
        if (!optionalStore.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalStore.get(), HttpStatus.OK);
    }
}
