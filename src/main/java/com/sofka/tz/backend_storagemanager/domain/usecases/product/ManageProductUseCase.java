package com.sofka.tz.backend_storagemanager.domain.usecases.product;

import com.sofka.tz.backend_storagemanager.domain.model.product.entities.Product;
import com.sofka.tz.backend_storagemanager.domain.model.product.gateway.ProductRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Product UseCase
 *
 * @author Daniel Granados
 * @version 1.0.0
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class ManageProductUseCase {

    private final ProductRepository repository;

    public Flux<Product> findAll() {
        return repository.findAllProducts();
    }

    public Flux<Product> findAllPaginate(Integer skip, Integer limit) {
        return repository.findAllPaginated(skip, limit);
    }

    public Mono<Product> findById(String id) {
        return repository.getById(id);
    }

    public Mono<Product> saveProduct(Product product) {
        return repository.saveProduct(product);
    }

    public Mono<Product> updateProduct(Product product) {
        return repository.updateProduct(product);
    }
}
