package br.com.estudo.storechallenge.store.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddStoreRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String address;

}
