package br.com.estudo.storechallenge.store.response;

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

    private Long id;

    private String name;

    private String address;

    private BigDecimal totalDay;

    private BigDecimal totalMonth;

}

