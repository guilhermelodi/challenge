package br.com.estudo.storechallenge.store.client;

import br.com.estudo.storechallenge.store.config.OrderServiceConfiguration;
import br.com.estudo.storechallenge.store.response.StoreTotalSalesResponse;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="order-service")
@RibbonClient(name="order-service", configuration = OrderServiceConfiguration.class)
public interface OrderClient {

    @GetMapping("orders/stores/{storeId}/total-sales")
    StoreTotalSalesResponse findTotalSalesByStoreId(@PathVariable("storeId") Long storeId);

}
