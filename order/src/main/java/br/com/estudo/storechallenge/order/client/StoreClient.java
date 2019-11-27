package br.com.estudo.storechallenge.order.client;

import br.com.estudo.storechallenge.order.response.StoreResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="${service.url.store}", name="store")
public interface StoreClient {

    @GetMapping("{id}")
    StoreResponse findStoreById(@PathVariable("id") Long id);

}
