package br.com.estudo.storechallenge.store.client;

import br.com.estudo.storechallenge.store.response.StoreTotalSalesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="${service.url.order}", name="order")
public interface OrderClient {

    @GetMapping("stores/{storeId}/total-sales")
    StoreTotalSalesResponse findTotalSalesByStoreId(@PathVariable("storeId") Long storeId);

}
