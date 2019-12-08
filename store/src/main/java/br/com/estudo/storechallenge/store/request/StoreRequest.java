package br.com.estudo.storechallenge.store.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class StoreRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String address;

}
