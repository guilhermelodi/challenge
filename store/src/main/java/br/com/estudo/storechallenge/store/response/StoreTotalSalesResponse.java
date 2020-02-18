package br.com.estudo.storechallenge.store.response;

import br.com.estudo.storechallenge.store.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreTotalSalesResponse {

    private Store store;

    private BigDecimal totalDay;

    private BigDecimal totalMonth;

}

