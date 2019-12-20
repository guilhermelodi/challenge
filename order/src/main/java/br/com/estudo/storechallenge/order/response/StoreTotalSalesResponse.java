package br.com.estudo.storechallenge.order.response;

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

    private Long storeId;

    private BigDecimal totalDay;

    private BigDecimal totalMonth;

}
