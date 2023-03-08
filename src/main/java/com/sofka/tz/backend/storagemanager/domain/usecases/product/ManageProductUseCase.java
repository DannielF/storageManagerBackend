package com.sofka.tz.backend.storagemanager.domain.usecases.product;

import com.sofka.tz.backend.storagemanager.domain.model.product.gateway.ProductRepository;
import com.sofka.tz.backend.storagemanager.domain.model.product.entities.Product;
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

    public Mono<Product> decreaseInInventory(Integer value, String id) {
        return repository.decreaseInInventory(value, id);
    }

    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }
}
