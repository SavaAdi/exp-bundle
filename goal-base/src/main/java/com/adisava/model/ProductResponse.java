package com.adisava.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductResponse {

    public Long id;
    public String name;
}
