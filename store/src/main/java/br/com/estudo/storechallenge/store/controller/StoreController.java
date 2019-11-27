package br.com.estudo.storechallenge.store.controller;

import br.com.estudo.storechallenge.store.entity.Store;
import br.com.estudo.storechallenge.store.exception.StoreNotFoundException;
import br.com.estudo.storechallenge.store.service.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("stores")
@Api(value = "Store", tags = "Store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @ApiOperation(value = "Lists all stores")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Store>> listAllStores() {
        return new ResponseEntity<>(storeService.listAllStores(), HttpStatus.OK);
    }

    @ApiOperation(value = "Gets one store by id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Store> findStoreById(@PathVariable Long id) {
        Store store = storeService.findStoreById(id);

        return new ResponseEntity<>(store, HttpStatus.OK);
    }

}
