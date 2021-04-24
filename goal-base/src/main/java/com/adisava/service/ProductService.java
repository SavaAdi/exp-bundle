package com.adisava.service;

import com.adisava.persistance.Product;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class ProductService {

    public void prepare(Product product) {
        var originalPrice = product.getPrice();
        var someDiscountObtainedFromAService = new BigDecimal("0.3");
        product.setPrice(originalPrice.multiply(someDiscountObtainedFromAService));
    }

    public Uni<Product> save(Product product) {
        return product.persistAndFlush().replaceWith(product);
    }

    public Uni<List<Product>> findAll() {
        return Product.listAll();
    }

}
