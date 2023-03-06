package com.sofka.tz.backend_storagemanager.domain.product.gateway;

import com.sofka.tz.backend_storagemanager.domain.product.entities.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository {

    Flux<Product> findAllProducts();
    Flux<Product> findAllPaginated(Integer skip, Integer limit);
    Mono<Product> getById(String id);
    Mono<Product> saveProduct(Product product);
    Mono<Product> updateProduct(Product product);
}
