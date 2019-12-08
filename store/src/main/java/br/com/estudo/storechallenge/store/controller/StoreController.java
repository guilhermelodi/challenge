package br.com.estudo.storechallenge.store.controller;

import br.com.estudo.storechallenge.store.entity.Store;
import br.com.estudo.storechallenge.store.request.StoreRequest;
import br.com.estudo.storechallenge.store.service.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addStore(@Valid @RequestBody StoreRequest storeRequest) {
        Store store = storeService.add(storeRequest);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(store.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Update an existing store")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateStore(@PathVariable Long id, @Valid @RequestBody StoreRequest storeRequest) {
        Store store = storeService.update(id, storeRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete a store")
    public ResponseEntity<?> deleteStore(@PathVariable Long id) {
        storeService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
