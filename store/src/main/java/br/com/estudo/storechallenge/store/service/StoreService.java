package br.com.estudo.storechallenge.store.service;

import br.com.estudo.storechallenge.store.entity.Store;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StoreService {

    // Lista fixa enquanto não tenho banco de dados
    private List<Store> storeList = Arrays.asList(
            Store.builder()
                    .id(1L)
                    .address("Rua Francisco Matarazzo, 1705")
                    .name("Palmeiras Store")
                    .build(),
            Store.builder()
                    .id(2L)
                    .address("Rua Silva Jardim, 1234")
                    .name("Netshoes")
                    .build()
    );

    public List<Store> listAllStores() {
        return storeList;
    }

    public Optional<Store> findStoreById(Long id) {
        return storeList.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }

}