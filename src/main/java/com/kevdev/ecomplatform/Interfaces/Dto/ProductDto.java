package com.kevdev.ecomplatform.Interfaces.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private double productPrice;

    @JsonProperty("weight")
    private double productWeight;

    @JsonProperty("type")
    private String mainType;

    private String subType;
}
