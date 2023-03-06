package com.sofka.tz.backend_storagemanager.domain.model.product.gateway;

import com.sofka.tz.backend_storagemanager.domain.model.product.entities.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Product interface
 *
 * @author Daniel Granados
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ProductRepository {

    Flux<Product> findAllProducts();
    Flux<Product> findAllPaginated(Integer skip, Integer limit);
    Mono<Product> getById(String id);
    Mono<Product> saveProduct(Product product);
    Mono<Product> updateProduct(Product product);
}
