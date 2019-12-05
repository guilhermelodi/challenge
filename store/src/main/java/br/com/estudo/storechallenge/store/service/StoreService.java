package br.com.estudo.storechallenge.store.service;

import br.com.estudo.storechallenge.store.entity.Store;
import br.com.estudo.storechallenge.store.exception.StoreNotFoundException;
import br.com.estudo.storechallenge.store.repository.StoreRepository;
import br.com.estudo.storechallenge.store.request.AddStoreRequest;
import br.com.estudo.storechallenge.store.request.UpdateStoreRequest;
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

    public void add(AddStoreRequest addStoreRequest) {
        log.info("Adding new store. Name: {}", addStoreRequest.getName());

        Store store = new Store();

        // Nesta parte, eu pensei em fazer algo na Entity, tipo uma função:
        // copyFromRequest que transferia os dados para a Entity antes de salvar...
        // Já estou com o link do Dev Cave MapStruct para implementar no projeto
        store.setName(addStoreRequest.getName());
        store.setAddress(addStoreRequest.getAddress());

        storeRepository.save(store);
    }

    public void update(UpdateStoreRequest updateStoreRequest) {
        log.info("Updating store by ID: {}", updateStoreRequest.getId());

        Store store = findStoreById(updateStoreRequest.getId());

        // Nesta parte, eu pensei em fazer algo na Entity, tipo uma função:
        // copyFromRequest que transferia os dados para a Entity antes de salvar...
        // Já estou com o link do Dev Cave MapStruct para implementar no projeto
        store.setName(updateStoreRequest.getName());
        store.setAddress(updateStoreRequest.getAddress());

        storeRepository.save(store);
    }

    public void delete(Long id) {
        log.info("Deleting store by ID: {}", id);

        storeRepository.delete(findStoreById(id));
    }
}