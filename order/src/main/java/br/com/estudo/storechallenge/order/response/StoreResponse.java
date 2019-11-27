package br.com.estudo.storechallenge.order.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "Store")
public class StoreResponse {

    private Long id;

    private String name;

    private String address;

    private Date creationDate;

    private Date updateDate;

}
