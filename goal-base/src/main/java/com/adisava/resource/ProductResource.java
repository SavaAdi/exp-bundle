package com.adisava.resource;

import com.adisava.persistance.Product;
import com.adisava.service.ProductService;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.CREATED;

@Path("product")
public class ProductResource {

    @Inject
    ProductService productService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> saveProduct(@Valid Product product) {
        return Panache.withTransaction(() -> {
            productService.prepare(product);
            return product.persist();
        })
                .replaceWith(Response.ok(product)
                        .status(CREATED)
                        ::build);
    }

    @POST
    @Path("/svc")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> saveProductViaService(@Valid Product product) {
        return productService.save(product)
                .onItem()
                .transform(Response::ok)
                .onItem().transform(Response.ResponseBuilder::build);
    }

    @POST
    @Path("/nosvc")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveProductNotViaService(@Valid Product product) {
        return Response.ok(product.persistAndFlush())
                .build();
    }

    @GET
    public Uni<Response> findAll() {
        return productService.findAll().onItem()
                .transform(Response::ok)
                .onItem().transform(Response.ResponseBuilder::build);
    }

}
