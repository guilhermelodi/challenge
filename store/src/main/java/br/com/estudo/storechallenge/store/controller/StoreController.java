package br.com.estudo.storechallenge.store.controller;

import br.com.estudo.storechallenge.store.entity.Store;
import br.com.estudo.storechallenge.store.request.AddStoreRequest;
import br.com.estudo.storechallenge.store.request.UpdateStoreRequest;
import br.com.estudo.storechallenge.store.service.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ApiOperation(value = "Add a new store")
    @PostMapping
    public ResponseEntity<?> addStore(@RequestBody AddStoreRequest addStoreRequest) {
        storeService.add(addStoreRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update an existing store")
    @PutMapping
    public ResponseEntity<?> updateStore(@RequestBody UpdateStoreRequest updateStoreRequest) {
        storeService.update(updateStoreRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a store")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteStore(@PathVariable Long id) {
        storeService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
