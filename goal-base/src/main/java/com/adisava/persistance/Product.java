package com.adisava.persistance;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Product extends BaseEntity {

    private static final long serialVersionUID = -988040165435740444L;

    private String name;

    private BigDecimal price;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
