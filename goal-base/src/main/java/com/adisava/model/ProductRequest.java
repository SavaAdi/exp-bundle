package com.adisava.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
@Builder
public class ProductRequest {

    public ProductRequest(@NotBlank String name, @PositiveOrZero BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public ProductRequest() {
    }

    @NotBlank
    private String name;

    @PositiveOrZero
    private BigDecimal price;
}
