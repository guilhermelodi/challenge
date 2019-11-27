package br.com.estudo.storechallenge.order.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "Store")
public class StoreResponse {

    private Long id;

    private String name;

    @JsonIgnore
    private String address;

    @JsonIgnore
    private Date creationDate;

    @JsonIgnore
    private Date updateDate;

}
