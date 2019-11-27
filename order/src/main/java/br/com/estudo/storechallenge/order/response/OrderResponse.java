package br.com.estudo.storechallenge.order.response;

import br.com.estudo.storechallenge.order.entity.Order;
import br.com.estudo.storechallenge.order.entity.OrderItem;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@ApiModel(value = "Order")
public class OrderResponse {

    private Long id;

    private StoreResponse store;

    private String user;

    private String address;

    private LocalDateTime confirmationDate;

    private Integer status;

    private List<OrderItem> items;

    private Long paymentId;

    private LocalDateTime creationDate;

    private LocalDateTime updateDate;


    public static OrderResponse fromEntity(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .user(order.getUser())
                .address(order.getAddress())
                .confirmationDate(order.getConfirmationDate())
                .status(order.getStatus())
                .items(order.getItems())
                .paymentId(order.getPaymentId())
                .creationDate(order.getCreationDate())
                .updateDate(order.getUpdateDate())
                .build();
    }

}
